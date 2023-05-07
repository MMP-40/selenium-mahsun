package Class;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;

public class ExecutionTimeReportPlugin implements ConcurrentEventListener {
	private Map<String, Instant> startTimeMap;
	private Map<String, Long> executionTimeMap;
	
	public ExecutionTimeReportPlugin() {
		startTimeMap = new HashMap<>();
		executionTimeMap = new HashMap<>();
	}

	@Override
	public void setEventPublisher(EventPublisher publisher) {
		// TODO Auto-generated method stub
		publisher.registerHandlerFor(TestRunStarted.class, this::onTestRunStarted);
		publisher.registerHandlerFor(TestCaseStarted.class, this::onTestCaseStarted);
		publisher.registerHandlerFor(TestCaseFinished.class, this::onTestCaseFinsihed);
		publisher.registerHandlerFor(TestRunFinished.class, this::onTestRunFinished);
	}

	private void onTestRunStarted(TestRunStarted event) {
		// Initialize the data structures for storing start times and execution times
		startTimeMap.clear();
		executionTimeMap.clear();
	}
	
	private void onTestCaseStarted(TestCaseStarted event) {
		// Store the time of the test case
		String testCaseName = event.getTestCase().getName();
		Instant startTime = event.getInstant();
		startTimeMap.put(testCaseName, startTime);
	}
	
	private void onTestCaseFinsihed(TestCaseFinished event) {
		// Calculate the execution time of the test case and store it
		String testCaseName = event.getTestCase().getName();
		Instant endTime = event.getInstant();
		Instant startTime = startTimeMap.get(testCaseName);
		long executionTime = Duration.between(startTime, endTime).toMillis();
		executionTimeMap.put(testCaseName, executionTime);		
	}
	
	private void onTestRunFinished(TestRunFinished event) {
		// Generate the Json report with the execution times
		try (FileWriter file = new FileWriter("execution_time_report.json")) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String jsonReport = gson.toJson(executionTimeMap);
			file.write(jsonReport);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
