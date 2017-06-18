package service;

import model.Message;

import java.util.List;

/**
 * Created by Zamuna on 6/18/2017.
 */
public class MessageService extends AbstractService<Message> {
    public MessageService(Class<Message> clazz) {
        super(clazz);
    }

    public Message insertMessage(Message message){
        System.out.println("Message : "+message);
        Message message1 = post(null, message);
        return message1;
    }

    public Message updateMessage(Message message, Long id){
        System.out.println("Update Message");
        Message message1=put(id.toString(),message);
        return message1;
    }

    public Message getMessage(Long message){
        Message message1= getById(message.toString());
        return message1;
    }
    public List<Message> getAllMessage(){
//        List<Message> messages=getAll(null)
        return null;
    }

    public static void main(String[] args) {
        MessageService messageService=new MessageService(Message.class);
        Message message=new Message();
       message.setId(1L);
       message.setReceiverId(1L);
       message.setSenderId(2L);
       message.setText("Hello There");
        messageService.insertMessage(message);
//        message=messageService.updateMessage(message, 1l);
//        System.out.println(message);
        Long id=5l;
//        messageService.getMessage(6l);

    }
}

