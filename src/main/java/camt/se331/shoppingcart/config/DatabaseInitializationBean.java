package camt.se331.shoppingcart.config;

import camt.se331.shoppingcart.entity.Event;
import camt.se331.shoppingcart.entity.Member;
import camt.se331.shoppingcart.entity.Product;
import camt.se331.shoppingcart.repository.EventRepository;
import camt.se331.shoppingcart.repository.MemberRepository;
import camt.se331.shoppingcart.repository.ProductRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

@Profile("db.init")
@Component
public class DatabaseInitializationBean implements InitializingBean {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EventRepository eventRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        Product[] initProduct = {
                new Product(1l,"Kindle","the good book reader",6900.00),
                new Product(2l,"Surface Pro","The unknow computer",34000.00),
                new Product(3l,"Mac pro"," Mac book interim",44000.00),
                new Product(4l,"Candle","use for lightenup the world",10.00),
                new Product(5l,"Bin","User for what ?",200.00),
                new Product(6l,"Telephone", "Call the others",150.00),
                new Product(7l,"iPhone","What is it?",26000.00),
                new Product(8l,"Galaxy Note 4","Who still use this ?",24000.00),
                new Product(9l,"AngularJS","we hate it",2000.00),
                new Product(10l,"Mazda 3","Very handsome guy use this",300000.00)
        };
        productRepository.save(Arrays.asList(initProduct));

        // status = 0, admin
        // status = 1, member
        Member[] initMember = {
            new Member(1l,"Tanawat", "Sitthitan", "nettanawat@gmail.com", "zxcv1234", null,1,0),
                new Member(2l,"Sam", "Smith", "sam@gmail.com", "zxcv1234", null,1,1),
                new Member(3l,"Smith", "Ryan", "rhan@gmail.com", "zxcv1234", null,1,1),
                new Member(4l,"John", "Legend", "johnlegend@gmail.com", "zxcv1234", null,1,1)
        };
        memberRepository.save(Arrays.asList(initMember));
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        Event[] iniEvent = {
                new Event(1l,"Test","description r=test sadasdad", cal.getTime(), 8,0,16,0,"Chaing mai",21.2131321,32.323233,1,1),
                new Event(2l,"SSDSD","description r=test sadasdad",  cal.getTime(), 8,0,16,0,"Chaing mai",21.2131321,32.323233,1,1),
                new Event(3l,"asdads","description r=test sadasdad",  cal.getTime(), 8,0,16,0,"Chaing mai",21.2131321,32.323233,1,1),
                new Event(4l,"fdsgdgdg","description r=test sadasdad",  cal.getTime(), 8,0,16,0,"Chaing mai",21.2131321,32.323233,1,1),
                new Event(5l,"123dsadas","description r=test sadasdad",  cal.getTime(), 8,0,16,0,"Chaing mai",21.2131321,32.323233,1,1),
                new Event(6l,"gdffsdasd","description r=test sadasdad",  cal.getTime(), 8,0,16,0,"Chaing mai",21.2131321,32.323233,1,1),
        };
        eventRepository.save(Arrays.asList(iniEvent));
    }
}