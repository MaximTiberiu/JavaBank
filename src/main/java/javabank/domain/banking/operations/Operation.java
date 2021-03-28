package javabank.domain.banking.operations;

import java.util.Date;
import java.util.Objects;

public class Operation {
    private Date operationDate;
    private String operationDetails;
    private boolean successfulOperation;

    /**
     * Constructor that creates a new Operation
     * @param operationDate Date,           representing the date&time when the Operation was performed
     * @param operationDetails String,      representing the details of the Operation
     * @param successfulOperation boolean,  representing the value that shows whether the operation was successfully performed
     */
    public Operation(Date operationDate, String operationDetails, boolean successfulOperation) {
        this.operationDate = operationDate;
        this.operationDetails = operationDetails;
        this.successfulOperation = successfulOperation;
    }

    /**
     * @return Date, representing the date&time when the Operation was performed
     */
    public Date getOperationDate() {
        return operationDate;
    }

    /**
     * @param operationDate Date, representing the new date&time when the Operation was performed
     */
    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    /**
     * @return String, representing the details of the Operation
     */
    public String getOperationDetails() {
        return operationDetails;
    }

    /**
     * @param operationDetails String, representing the new details of the Operation
     */
    public void setOperationDetails(String operationDetails) {
        this.operationDetails = operationDetails;
    }

    /**
     * @return boolean, representing the value that shows whether the operation was successfully performed
     */
    public boolean isSuccessfulOperation() {
        return successfulOperation;
    }

    /**
     * @param successfulOperation boolean, representing the new value that shows whether the operation was successfully performed
     */
    public void setSuccessfulOperation(boolean successfulOperation) {
        this.successfulOperation = successfulOperation;
    }

    /**
     * @return String, representing the serialization of a Operation | TODO: Implement Serialization
     */
    @Override
    public String toString() {
        return "Operation{" +
                "operationDate=" + operationDate +
                ", operationDetails='" + operationDetails + '\'' +
                ", successfulOperation=" + successfulOperation +
                '}';
    }

    /**
     * ethod that verifies if two Operation objects are equal
     * @param obj Object, representing the Object to be verified
     * @return  true,   if the successfulOperation of the Operation is equal to the successfulOperation of the Object,
     *                  the operationDate of the Operation is equal to the operationDate of the Object,
     *                  and the operationDetails of the Operation is equal to the operationDetails of the Object
     *          false,  otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Operation that = (Operation) obj;
        return successfulOperation == that.successfulOperation && operationDate.equals(that.operationDate) && operationDetails.equals(that.operationDetails);
    }

    /**
     * Method that gets the hashCode of the Operation
     * @return int, representing the hashCode of the Operation
     */
    @Override
    public int hashCode() {
        return Objects.hash(operationDate, operationDetails, successfulOperation);
    }
}
