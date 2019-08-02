package se.lexicon.account.component.test.common.entity;
import se.lexicon.account.component.entity.AccountEntity;
import com.so4it.common.util.object.Required;
import com.so4it.test.domain.AbstractTestBuilder;
import se.lexicon.account.component.entity.OrderEntity;
import java.math.BigDecimal;
/**
 * @author Magnus Poromaa {@literal <mailto:magnus.poromaa@so4it.com/>}
 */

public class AccountEntityTestBuilder extends AbstractTestBuilder<AccountEntity> {


    private AccountEntity.Builder builder;

    public AccountEntityTestBuilder(AccountEntity.Builder builder) {
        this.builder = Required.notNull(builder, "builder");
        this.builder
                .withId("1111111111")
                .withAmount(BigDecimal.TEN);
    }

    public static AccountEntityTestBuilder builder() {
        return new AccountEntityTestBuilder(AccountEntity.builder());
    }

    @Override
    public AccountEntity build() {
        return builder.build();
    }

    /**
     * @author Magnus Poromaa {@literal <mailto:magnus.poromaa@so4it.com/>}
     */
    public static class OrderEntityTestBuilder extends AbstractTestBuilder<OrderEntity> {

        private OrderEntity.Builder builder;

        public OrderEntityTestBuilder(OrderEntity.Builder builder) {
            this.builder = Required.notNull(builder, "builder");
            this.builder
                    .withId("1111111111")
                    .withSsn("1111111111")
                    .withAmount(BigDecimal.TEN)
                    .withOrderBookId("123");
        }

        public static OrderEntityTestBuilder builder() {
            return new OrderEntityTestBuilder(OrderEntity.builder());
        }

        @Override
        public OrderEntity build() {
            return builder.build();
        }
    }
}