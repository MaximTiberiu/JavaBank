package javabank.domain.banking.operations;

import java.util.Date;

public class BillPayment extends Operation {
    /**
     * Constructor that creates a new Operation
     *
     * @param operationDate       Date,           representing the date&time when the Operation was performed
     * @param operationDetails    String,      representing the details of the Operation
     * @param successfulOperation boolean,  representing the value that shows whether the operation was successfully performed
     */
    public BillPayment(Date operationDate, String operationDetails, boolean successfulOperation) {
        super(operationDate, operationDetails, successfulOperation);
    }
}
