package apple.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Api {
	private String apiId;
	private String apiName;
	private String type;
	private String url;
}
