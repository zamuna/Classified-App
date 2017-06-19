package service;

import model.Message;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Zamuna on 6/18/2017.
 */
public class MessageService extends AbstractService<Message> implements IService<Message>{
    private static final List<String> searchFields = Arrays.asList("name");
    public MessageService(Class<Message> clazz) {
        super(clazz);
    }

    public Message getMessage(Long message){
        return null;
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
        messageService.insert(message);
//        message=messageService.updateMessage(message, 1l);
//        System.out.println(message);
        Long id=5l;
//        messageService.getMessage(6l);

    }

    @Override
    public Object insert(Message message) {
        System.out.println("Message : "+message);
        Object message1 = post(null, message, this.getClass());
        return message1;
    }

    @Override
    public Object update(Message message, String id) {
        System.out.println("Update Message");
        Object message1=put(id.toString(),message);
        return message1;
    }

    @Override
    public Message get(String id) {
        return null;
    }

    @Override
    public List<Message> getAllData(String url, String searchText, Integer offset, Integer limit) {
        return getAll(url, searchText, offset, limit);
    }
}

