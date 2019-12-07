package first.response;

import first.pojo.Details;
import lombok.Data;

import java.util.List;

@Data
public class DetailsResponse {
    private Integer page;

    private Long total;

    private List<Details> details;
}
