package nn.estore.jpa.service;

import nn.estore.jpa.entity.ReportItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@SpringBootTest
class ReportServiceImplTest {
    @Autowired
    private ReportService reportService;
    @Test
    void getInventoryData() {
        // GIVEN
        List<ReportItem> reportItems = reportService.getInventoryData();
        // THEN
        Assertions.assertNotNull(reportItems);
        Assertions.assertEquals(8, reportItems.size());
    }

    @Test
    void getRevenueByCategoryData() {
        // GIVEN
        List<ReportItem> reportItems = reportService.getRevenueByCategoryData();
        // THEN
        Assertions.assertNotNull(reportItems);
        Assertions.assertEquals(8, reportItems.size());
    }

    @Test
    void getRevenueByMonthData() {
        // GIVEN
        List<ReportItem> reportItems = reportService.getRevenueByMonthData();
        // THEN
        Assertions.assertNotNull(reportItems);
        Assertions.assertEquals(12, reportItems.size());
    }

    @Test
    void getVIPCustomerData() {
        // GIVEN
        List<ReportItem> reportItems = reportService.getVIPCustomerData();
        // THEN
        Assertions.assertNotNull(reportItems);
        Assertions.assertEquals(93, reportItems.size());
    }
}