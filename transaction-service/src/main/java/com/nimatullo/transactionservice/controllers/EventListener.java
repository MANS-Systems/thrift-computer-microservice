package com.nimatullo.transactionservice.controllers;

//@Component
public class EventListener {
//    private TransactionEventDatabase db;
//    private TransactionDatabase transactionDatabase;
//    Logger logger = LoggerFactory.getLogger(EventListener.class);
//    public EventListener(TransactionEventDatabase db, TransactionDatabase transactionDatabase) {
//        this.db = db;
//        this.transactionDatabase = transactionDatabase;
//    }
//
//    @StreamListener(EventStream.INBOUND)
//    public void handleGreetings(@Payload Message<PaymentResponse> message) {
//        PaymentResponse paymentResponse = message.getPayload();
//        if (paymentResponse.getStatus() == PaymentStatus.CARD_APPROVED) {
//            changeTransactionStatusToSuccessful(paymentResponse.getTransactionId());
//        }
//        else if (paymentResponse.getStatus() == PaymentStatus.CARD_DECLINED) {
//            changeTransactionStatusToFailed(paymentResponse.getTransactionId());
//        }
//        logger.info(db.get(message.getMessageId()).getStatus().toString());
//    }
//
//    private void changeTransactionStatusToSuccessful(UUID id) {
//        db.get(id).setStatus(TransactionStatus.SUCCESSFUL);
//        transactionDatabase.get(id).setStatus(TransactionStatus.SUCCESSFUL);
//    }
//
//    private void changeTransactionStatusToFailed(UUID id) {
//        db.get(id).setStatus(TransactionStatus.FAILED);
//        transactionDatabase.get(id).setStatus(TransactionStatus.FAILED);
//    }
}
