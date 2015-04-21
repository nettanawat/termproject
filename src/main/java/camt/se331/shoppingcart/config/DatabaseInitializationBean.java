package camt.se331.shoppingcart.config;

import camt.se331.shoppingcart.entity.*;
import camt.se331.shoppingcart.repository.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;

@Profile("db.init")
@Component
public class DatabaseInitializationBean implements InitializingBean {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    CommentForumRepository commentForumRepository;
    @Autowired
    ForumRepository forumRepository;

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
        Calendar cal = new GregorianCalendar(2015, 4, 7);
        Event[] iniEvent = {
                new Event(1l,"Test","description r=test sadasdad", cal.getTime(), 8,0,16,0,"Chaing mai",21.2131321,32.323233,1,1),
                new Event(2l,"SSDSD","description r=test sadasdad",  cal.getTime(), 8,0,16,0,"Chaing mai",21.2131321,32.323233,1,1),
                new Event(3l,"asdads","description r=test sadasdad",  cal.getTime(), 8,0,16,0,"Chaing mai",21.2131321,32.323233,1,1),
                new Event(4l,"fdsgdgdg","description r=test sadasdad",  cal.getTime(), 8,0,16,0,"Chaing mai",21.2131321,32.323233,1,1),
                new Event(5l,"123dsadas","description r=test sadasdad",  cal.getTime(), 8,0,16,0,"Chaing mai",21.2131321,32.323233,1,1),
                new Event(6l,"gdffsdasd","description r=test sadasdad",  cal.getTime(), 8,0,16,0,"Chaing mai",21.2131321,32.323233,1,1),
        };
        eventRepository.save(Arrays.asList(iniEvent));


        CommentForum[] initCommentForums = {
                new CommentForum(1l, "Wow, that's really cool", 1l, cal.getTime(), 1),
                new CommentForum(2l, "Hey, that's really cool", 2l, cal.getTime(), 1),
                new CommentForum(3l, "Huh, that's really cool", 3l, cal.getTime(), 1),
                new CommentForum(4l, "Whattttt, that's really cool", 4l, cal.getTime(), 1)
        };
        commentForumRepository.save(Arrays.asList(initCommentForums));

        List<CommentForum> commentForumList = new ArrayList<>();
        commentForumList.addAll(Arrays.asList(initCommentForums));

//        Forum[] initForum ={
//                new Forum(1l,"Where is Wat Chedi Luang?", "I want to know the exact location od this place", 1l, cal.getTime(),1),
//                new Forum(2l,"How can I get there?","I will arrived Chiang Mai next week and I will stay at Nimman Hotel. Can you recommend me how to go there please?", 2l, cal.getTime(),1),
//                new Forum(3l,"Is this temple is the main temple of Chiang Mai?", "I going to write an academic essay about temple in Chiang Mai and I interested in Wat Chedi Luang. I want to know the information about this temple. Thank you", 3l, cal.getTime(),1),
//                new Forum(4l,"Any tourist attraction near Wat Chedi Luang?", "I will go there next week but I don't know the place that I can visit after Wat Chedi Luang. Can someone recommend me the place?", 4l, cal.getTime(),1),
//        };
        Forum forum = new Forum();
//        initForum[0].setCommentForumList(commentForumList[0]);
        forum.setId(1l);
        forum.setDetail("sssssss");
        forum.setDate(cal.getTime());
        forum.setCommentForumList(commentForumList);
        forum.setPostBy(2l);
        forum.setTitle("Heusadasd");
        forum.setStatus(1);
        forumRepository.save(forum);

    }
}