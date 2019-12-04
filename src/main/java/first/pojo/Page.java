package first.pojo;

import lombok.Data;

@Data
public class Page {
    private Integer page;//当前页
    private Integer pages;//总页
    private Integer size;//每页显示几条数据
    private Integer totals;//总条数
}
