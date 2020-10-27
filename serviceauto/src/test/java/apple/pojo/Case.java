package apple.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Case {
	private String caseId;
	private String desc;
	private String apiId;
	private String params;
}
