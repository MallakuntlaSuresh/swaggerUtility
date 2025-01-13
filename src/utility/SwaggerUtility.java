package utility;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SwaggerUtility {

	static String XXURL_ValueXX = "/user/register";
	static String XXTag_nameXX = "User";
	static String XXDescription_ValueXX = "To Register User";
	static String XXOperationID_ValueXX = "registerUser";
	static String XXINPUTSchema_NameXX = "userinput";
	static String XXOUTPUTSchema_NameXX = "useroutput";

	static String outputFieldstr = "name,age,mobno,email,dateofbirth,id,password,dateofcreation";
	static String inputFieldstr = "name,age,mobno,email,dateofbirth";

	public static void main(String[] args) throws IOException {

		String fieldStr = "            XXXFldNameXXX:\r\n" + "              type: string\r\n"
				+ "              description: XXXFldNameXXX\n";

		String text = new String(Files.readAllBytes(Paths.get("samplePayload.txt")), StandardCharsets.UTF_8);
		text = text.replaceAll("XXURL_ValueXX", XXURL_ValueXX);
		text = text.replaceAll("XXTag_nameXX", XXTag_nameXX);

		text = text.replaceAll("XXDescription_ValueXX", XXDescription_ValueXX);
		text = text.replaceAll("XXOperationID_ValueXX", XXOperationID_ValueXX);
		text = text.replaceAll("XXOUTPUTSchema_NameXX", XXOUTPUTSchema_NameXX);
		text = text.replaceAll("XXINPUTSchema_NameXX", XXINPUTSchema_NameXX);

		String[] inputFields = inputFieldstr.split(",");
		StringBuffer inputSchemaStr = new StringBuffer();
		for (String fieldName : inputFields) {
			inputSchemaStr.append(fieldStr.replaceAll("XXXFldNameXXX", fieldName));
		}
		text = text.replaceAll("XXINPUT_PROPERSXX", "\n" + inputSchemaStr.toString());

		String[] outputFields = outputFieldstr.split(",");
		StringBuffer outputStr = new StringBuffer();
		for (String fieldName : outputFields) {
			outputStr.append(fieldStr.replaceAll("XXXFldNameXXX", fieldName));
		}
		text = text.replaceAll("XXOUTPUT_PROPERSXX", "\n" + outputStr.toString());

		System.out.println(text);
	}

}
