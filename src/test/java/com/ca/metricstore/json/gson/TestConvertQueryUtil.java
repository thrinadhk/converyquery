package com.ca.metricstore.json.gson;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ca.metricstore.json.model.AttributeNameSpecifier;
import com.ca.metricstore.json.model.QuerySpecifier;
import com.ca.metricstore.json.model.SourceNamesSpecifier;

public class TestConvertQueryUtil {

	
	private QuerySpecifier createQuerySpecifier() {
		QuerySpecifier qs = new QuerySpecifier();
		qs.setOp("SPEC");
		
		SourceNamesSpecifier sns = new SourceNamesSpecifier();
		sns.setOp("EXACT");
		sns.setNames(new String[]{"SuperDomain|tas-cz-n2c|Nowhere Bank|Portal", "TWO"});
		qs.setSourceNameSpecifier(sns);
		
		AttributeNameSpecifier ans = new AttributeNameSpecifier();
		ans.setOp("REGEX");
		ans.setPattern("Portal\\|Frontends\\|Apps\\|[^|]+:Average Response Time \\(ms\\)");
		qs.setAttributeNameSpecifier(ans);
		
		return qs;
	}
	
	@Test
	public void testConvertQuerySpecifier() {
		
		QuerySpecifier qs = createQuerySpecifier();
		assertNotNull(ConvertQueryUtil.ConvertQuerySpecifier(qs));
	}
	
	@Test
	public void testConvertQuerySpecifierNull() {
		
		assertEquals(ConvertQueryUtil.ConvertQuerySpecifier(null), "null");
	}

}
