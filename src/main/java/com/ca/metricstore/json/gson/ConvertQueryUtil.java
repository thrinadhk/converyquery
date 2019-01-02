package com.ca.metricstore.json.gson;

import com.ca.metricstore.json.model.AttributeNameSpecifier;
import com.ca.metricstore.json.model.ExpressionsTasFilter;
import com.ca.metricstore.json.model.InputExternalTasFilter;
import com.ca.metricstore.json.model.InputTasFilter;
import com.ca.metricstore.json.model.QuerySpecifier;
import com.ca.metricstore.json.model.SourceNamesSpecifier;
import com.ca.metricstore.json.model.TasFilter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class ConvertQueryUtil {

	// singleton json object
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public static String ConvertQuerySpecifier(QuerySpecifier querySpecifier) {

		String jsonQS = gson.toJson(querySpecifier);
		return jsonQS;
	}

	public static String ConvertTasFilter(TasFilter tasFilter) {

		String jsonQS = gson.toJson(tasFilter);
		return jsonQS;
	}

	public static void main(String[] args) {

		//https://cawiki.ca.com/display/APM/Metric+Series+Metadata#MetricSeriesMetadata-POST/metadata/queryMetric
		QuerySpecifier qs = createQuerySpecifier();
		System.out.println("Query Specifier Object:\n" + qs);
		String jsonQS = gson.toJson(qs);
		System.out.println("Query Specifier:\n" + jsonQS);
		
		//http://truss-na-scx.ca.com/builds/jenkins-upload/nextgen/master/#tas-filter
		TasFilter tf = createTasFilter();
		System.out.println("TAS Filter Object:\n" + tf);
		jsonQS = gson.toJson(tf);
		System.out.println("TAS Filter:\n" + jsonQS);

	}
	public static TasFilter createTasFilter() {
		
		InputTasFilter itf1 = new InputTasFilter();
		itf1.setOp("ATTRIBUTE");
		ExpressionsTasFilter etf1 = new ExpressionsTasFilter();
		etf1.setName("type");
		etf1.setValues(new String[] { "BUSINESSTRANSACTION" });
		itf1.setExpressions(new ExpressionsTasFilter[] {etf1});
		
		InputTasFilter itf2 = new InputTasFilter();
		itf2.setOp("ATTRIBUTE");
		ExpressionsTasFilter etf2 = new ExpressionsTasFilter();
		etf2.setName("serviceIdAsAttribute");
		etf2.setValues(new String[] { "ApplicationService" });
		itf2.setExpressions(new ExpressionsTasFilter[] {etf2});

		
		InputExternalTasFilter ietf = new InputExternalTasFilter();
		ietf.setOp("OR");
		ietf.setInputs(new InputTasFilter[] {itf1, itf2});
		
		TasFilter tf = new TasFilter();
		tf.setOp("TAKE_VERTICES");
		tf.setInput(ietf);
		
		return tf;
		
	}

	public static QuerySpecifier createQuerySpecifier() {
		QuerySpecifier qs = new QuerySpecifier();
		qs.setOp("SPEC");

		SourceNamesSpecifier sns = new SourceNamesSpecifier();
		sns.setOp("EXACT");
		sns.setNames(new String[] { "SuperDomain|tas-cz-n2c|Nowhere Bank|Portal" });
		qs.setSourceNameSpecifier(sns);

		AttributeNameSpecifier ans = new AttributeNameSpecifier();
		ans.setOp("REGEX");
		ans.setPattern("Portal\\|Frontends\\|Apps\\|[^|]+:Average Response Time \\(ms\\)");
		qs.setAttributeNameSpecifier(ans);

		return qs;
	}

}
