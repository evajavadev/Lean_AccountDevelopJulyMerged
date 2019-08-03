package se.lexicon.account.component.service;
import se.lexicon.account.component.domain.Account;
import com.so4it.gs.rpc.Broadcast;
import com.so4it.gs.rpc.Routing;
import java.math.BigDecimal;

public interface AccountComponentService {


    String DEFAULT_BEAN_NAME = "accountComponentService";

    //account.hashCode() % numberOfPartitions
    void createAccount(@Routing("getSsn") Account account);

    //account.hashCode() % numberOfPartitions
    Account getAccount(@Routing String ssn);

    @Broadcast(reducer = BigDecimalRemoteResultReducer.class)
    BigDecimal getTotalAmountOnAccounts();
}