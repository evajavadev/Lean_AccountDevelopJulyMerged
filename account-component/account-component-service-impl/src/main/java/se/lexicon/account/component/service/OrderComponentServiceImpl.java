package se.lexicon.account.component.service;
import se.lexicon.account.component.entity.OrderEntity;
import com.so4it.common.util.object.Required;
import com.so4it.gs.rpc.ServiceExport;
import se.lexicon.account.component.domain.Order;
import se.lexicon.account.component.domain.Orders;
import se.lexicon.account.componment.dao.OrderDao;
import java.math.BigDecimal;
import java.util.stream.Collectors;

@ServiceExport({OrderComponentService.class})
public class OrderComponentServiceImpl implements OrderComponentService {


    private OrderDao orderDao;

    public OrderComponentServiceImpl(OrderDao orderDao) {
        this.orderDao = Required.notNull(orderDao,"orderDao");
    }

    @Override
    public Orders getOrders(String ssn) {
        return Orders.valueOf(orderDao.readAll(OrderEntity.templateBuilder()
                .withSsn(ssn).build()).stream().
                map( entity -> Order.builder()
                        .withId(entity.getId())
                        .withSsn(ssn)
                        .withAmount(entity.getAmount())
                        .withOrderBookId("").build())
                .collect(Collectors.toSet()));
    }

    @Override
    public void placeOrder(Order order) {
        orderDao.insert(OrderEntity.builder()
                .withSsn(order.getSsn())
                .withAmount(order.getAmount())
                .build());
    }

    @Override
    public BigDecimal getTotalOrderValueOfAllAccounts() {
        return orderDao.sum();
    }
}