package first.response;

import first.pojo.Area;
import first.pojo.Brand;
import first.pojo.Details;
import lombok.Data;

import java.util.List;

@Data
public class ShortRentResponse {
    private List<Brand> brand;

    private List<Details> carName;

    private List<Area> area;

    private DetailsResponse detailsResponse;
}
