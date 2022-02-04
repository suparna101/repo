package com.hcl.adi.chf.lambda.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.hcl.adi.chf.lambda.GetAvailableReadingsByPatientId;
import com.hcl.adi.chf.model.PatientReadingResponse;
import com.hcl.adi.chf.util.Constants;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class GetAvailableReadingsByPatientIdTest {
	private static final Logger LOGGER = LogManager.getLogger(GetAvailableReadingsByPatientIdTest.class.getName());
	private static Map<String, Integer> input;

	@BeforeClass
	public static void createInput() throws IOException {
		// set up your sample input object here.
		input = new HashMap<String, Integer>();
		input.put(Constants.QUERY_PARAM_PATIENT_ID, 1);
		input.put(Constants.QUERY_PARAM_PAGE_START_INDEX, 1);
		input.put(Constants.QUERY_PARAM_PAGE_COUNT, 1);
	}

	private Context createContext() {
		TestContext ctx = new TestContext();

		// customize your context here if needed.
		ctx.setFunctionName("Your Function Name");

		return ctx;
	}

	@Test
	public void testGetAvailableReadingsByPatientId() {
		GetAvailableReadingsByPatientId handler = new GetAvailableReadingsByPatientId();
		Context ctx = createContext();

		PatientReadingResponse patientReadingResponse = handler.handleRequest(input, ctx);
		LOGGER.info(patientReadingResponse);

		// validate output here.
		Assert.assertNotNull(patientReadingResponse);
	}
}