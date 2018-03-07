package com.ws.juxtarem.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class for JSONUtilities
 * 
 * @author Mihaela Munteanu
 * @since 7th of March 2018
 *
 */
public class JSONUtilsTest {
	private static final String TYPE = "type";
	private static final String NAME = "name";
	private static final String WORK = "work";
	private static final String HOME = "home";

	@Test
	public void testBuildJsonString() {
		String pairCode = "code";
		String pairValue = "001";
		
		String jsonPairResult = JSONUtils.buildJSONPair(pairCode, pairValue);
		System.out.println(jsonPairResult);
		assertEquals("Build json pair is not working as intended - ", "\"code\" : \"001\"", jsonPairResult);
		
		pairCode = "books";
		String pairValue1 = "Jungle Book";
		String pairValue2 = "Mona";
		
		String jsonParentResult = JSONUtils.buildJSONPair(pairCode, pairValue1, pairValue2);
		System.out.println(jsonParentResult);
		assertEquals("Build json parent is not working as intended - ", "\"books\" : [\"Jungle Book\",\"Mona\"]", jsonParentResult);
		
		String jsonRootParentResult = JSONUtils.buildJSONParent("root", jsonPairResult, jsonParentResult);
		System.out.println(jsonRootParentResult);
		assertEquals("Build json root parent is not working as intended - ", "\"root\" : {\"code\" : \"001\",\"books\" : [\"Jungle Book\",\"Mona\"]}", jsonRootParentResult);
		
		String typePair1 = JSONUtils.buildJSONPair(TYPE, HOME);
		String namePair1 = JSONUtils.buildJSONPair(NAME, "john@gmail.com");
		String rootlessParent1 = JSONUtils.buildJSONParent(null, typePair1, namePair1);
		
		String typePair2 = JSONUtils.buildJSONPair(TYPE, WORK);
		String namePair2 = JSONUtils.buildJSONPair(NAME, "john@yahoo.com");
		String rootlessParent2 = JSONUtils.buildJSONParent(null, typePair2, namePair2);
		String emailPair = JSONUtils.buildJSONList("email", rootlessParent1, rootlessParent2);
		String emailRoot = JSONUtils.buildJSONParent(null, emailPair);
		
		System.out.println();
		System.out.println("------ Example 3 ----------");
		System.out.println();
		System.out.println(typePair1);
		System.out.println(namePair1);
		System.out.println(typePair2);
		System.out.println(namePair2);
		System.out.println(emailPair);
		System.out.println(emailRoot);
		
		String expectedRootlessList = "{\"email\" : [{\"type\" : \"home\",\"name\" : \"john@gmail.com\"},{\"type\" : \"work\",\"name\" : \"john@yahoo.com\"}]}";
		System.out.println("Expected: " + expectedRootlessList);
		assertEquals("Build json rootless parent is not working as intended - ", 
				expectedRootlessList, 
				emailRoot);
	}
}
