package first.utils;

import first.pojo.Page;

public class MyPage {
    public static Page myPage1(Integer totals,Page page){

        Integer size = page.getSize();
        Integer page1 = page.getPage();
        Integer max = totals / size;
        if (totals % size != 0) {
            max += 1;
        }
        if (page1 > max) {
            page.setPage(max);
        }
        page1 = page.getPage();
        if (page1 < 1) {
            page1 = 1;
        }
        page.setSart((page1 - 1) * size);
        return page;
    }

}
