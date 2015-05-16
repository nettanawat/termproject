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
        Calendar cal = new GregorianCalendar();
        Calendar cal1 = new GregorianCalendar(2015, 7, 7);
        Calendar cal2 = new GregorianCalendar(2015, 8, 7);
        Calendar cal3 = new GregorianCalendar(2015, 12, 7);
        Calendar cal4 = new GregorianCalendar(2015, 10, 7);
        Calendar cal5 = new GregorianCalendar(2015, 8, 7);

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
                new Member(1l,"Tanawat", "Sitthitan", "nettanawat@gmail.com", "zxcv1234", "0882537135", cal.getTime(), true, "ADMIN"),
                new Member(2l,"Sam", "Smith", "sam@gmail.com", "zxcv1234", "0882537135", cal1.getTime(), true, "USER"),
                new Member(3l,"Smith", "Ryan", "rhan@gmail.com", "zxcv1234", "0882537135", cal2.getTime(), true, "USER"),
                new Member(4l,"John", "Legend", "johnlegend@gmail.com", "zxcv1234", "0882537135", cal3.getTime(), true, "USER"),
                new Member(5l,"Smith", "Ryan", "rhan@gmail.com", "zxcv1234", "0882537135", cal4.getTime(), true, "USER"),
                new Member(6l,"Tanawat", "Sitthitan", "nettanawat@gmail.com", "zxcv1234", "0882537135", cal5.getTime(), true, "USER"),
                new Member(7l,"Sam", "Smith", "sam@gmail.com", "zxcv1234", "0882537135", cal3.getTime(), true, "USER")
        };
        memberRepository.save(Arrays.asList(initMember));

        Event[] iniEvent = {
                new Event(1l,"Father's Day","In Thailand, Birthday of the king, is set as Father's Day.[40] December 5 is the birthday of the current king, Bhumibol Adulyadej (Rama IX). Traditionally, Thais celebrate by giving their father or grandfather a Canna flower (ดอกพุทธรักษา Dok Buddha Ruksa), which is considered a masculine flower; however, this is not as commonly practiced today. Thai people will wear yellow on this day to show respect for the king, because yellow is the Color of the day for Monday, the day King Bhumibol Adulyadej was born. Thais flood the Sanam Luang, a massive park in front of the palace, to watch the king give his annual speech, and often stay until the evening, when there is a national ceremony. Thais will light candles and show respect to the king by declaring their faith. This ceremony happens in almost every village in Thailand, and even overseas at Thai organizations.", cal.getTime(), 8,0,24,0,"Chaing mai",21.2131321,32.323233, Arrays.asList(initMember), "annual", true),
                new Event(2l,"Visakha Puja Day","Visakha Puja Day is one of the greatest religious holidays which falls on the 15th day of the waxing moon in the 6th lunar month. The significant celebration is held to commemorate the Buddha's birth, enlightenment and death (Parinibbana). In Thailand, as a Buddhist country with His Majesty the King as the Upholder of all Religions, this auspicious day is celebrated throughout the country. Religious flags are flown. Religious ceremonies and merit makings are performed countrywide. Meanwhile, in the countryside people will wake up in the early morning to prepare food and sweets for monks, and at dawn they walk in a long line to the nearby temple where they will spend the greater part of the day in religious activities. The activities are usually centred around the temple where they attend sermons during the day and in the evening take part in the candle-lit procession that circumambulates the main chapel three times. In the procession, each person carries flowers, three incense sticks and a lighted candle in remembrance of the Triple Gems (The Buddha, His Teaching and His disciples).", cal1.getTime(), 8,0,24,0,"Chaing mai",21.2131321,32.323233, Arrays.asList(initMember), "annual", true),
                new Event(3l,"Make merits","Merit (Sanskrit puṇya, Pāli puñña) is a concept in Buddhism/Hinduism. It is that which accumulates as a result of good deeds, acts, or thoughts and which carries over throughout the life or the subsequent incarnations. Such merit contributes to a person's growth towards spiritual liberation. Merit can be gained in a number of ways, one of the sutras that reflect this teaching is the Sutra on the Ten Wholesome Ways of Actions which suggest ten ways in which merit-making can occur in the Buddhist context. In addition, according to the Mahayana Sutra of The Great Vows of Ksitigarbha Bodhisattva, one can transfer one-seventh of the merit of an act they have performed to a deceased loved one, such as in the Shitro practice, in order to diminish the deceased's suffering in their new existence. Pariṇāmanā (Sanskrit) may be rendered as 'transfer of merit' or 'dedication' and involves the transfer of merit as a cause to bring about an effect.", cal2.getTime(), 8,0,24,0,"Chaing mai",21.2131321,32.323233, Arrays.asList(initMember), "annual", true),
                new Event(4l,"Tak Bat Devo and Chak Phra Festivals","The tradition of “Tak Bat Devo” is derived from the word “Devorohana” which means the return of Lord Buddha from Heaven to Earth. At the end of the Buddhist Lent, which falls on the first day of the wanning moon of the eleventh lunar month, Lord Buddha returned to earth and was greeted by a crowd and Buddhist believers who were waiting to offer him food. The most famous ‘Tak Bat Devo’ ceremony in Thailand is at Wat Sankat Rattanakhiri in Uthai Thani. During the morning, about 500 Buddhist monks carry a Buddha image and descend down from Sakae Krang hilltop to receive alms and food offerings from devotees. The event symbolises the Buddha’s return to Earth after spending three months preaching to his mother in heaven.", cal3.getTime(), 8,0,24,0,"Chaing mai",21.2131321,32.323233, Arrays.asList(initMember), "other", true),
                new Event(5l,"Walking Street","The Sunday Market (or Walking Street) is a large market located right in the centre of the old walled city area of Chiang Mai. Starting at the Tha Phae Gate at one end the Sunday Market extends for roughly 1km down the full length of Ratchadamnoen Road. You can go to the Market every Sunday from 4pm till midnight. Ratchadamnoen Road is always closed to traffic while the Sunday Market is open. This allows shoppers to browse the goods on display, bargain with vendors for a good price and wander freely all around without watching over their shoulder for a motor bike zipping past.", cal4.getTime(), 8,0,24,0,"Chaing mai",21.2131321,32.323233, Arrays.asList(initMember), "other", true),
                new Event(6l,"Songkarn Festival","Songkran is a Sanskrit word in Thai form which means the entry of the sun into any sign of the Zodiac. But the Songkran in this particular instance is when the sun enters the sign of Aries or the Ram. Its full name is Maha Songkran or Major Songkran to distinguish it from the other ones. But the people call it simply the Songkran for it is the only one they know and in which they take interest. It is their traditional New Year when they can enjoy their holidays to the full with no economic hindrance. Songkran is a fixable feast on the solar calender. It begins on the 13th April and ends on the 15th April, but occasionally in certain years on the 16th April. The Songkran is in fact the celebration of the vernal equinox similar to those of the Indian Holi Festival, the Chinese Ching Ming, and the Christian Festival of Easter. The beginning of spring when the sun crosses the equator is now on the 21st of March which is due to the precession of the equinox. The Songkran Festival is in a certain sense like April Fool's Day, when the maids of the village play pranks on any gallant who happens to pass by their way. He will be caught and bound by the united strength of the maids and they will daub him with blacking.", cal5.getTime(), 8,0,24,0,"Chaing mai",21.2131321,32.323233, Arrays.asList(initMember), "other", true),
        };

        iniEvent[0].setImagePath("resources/images/chedi1.jpg");
        iniEvent[1].setImagePath("resources/images/chedi2.jpg");
        iniEvent[2].setImagePath("resources/images/chedi3.jpg");
        iniEvent[3].setImagePath("resources/images/chedi4.jpg");
        iniEvent[4].setImagePath("resources/images/chedi5.jpg");
        iniEvent[5].setImagePath("resources/images/chedi6.jpg");
        eventRepository.save(Arrays.asList(iniEvent));


        CommentForum[] initCommentForums1 = {
                new CommentForum(1l, "Wat Chedi Luang is on Prapokklao Road which runs roughly through the north-south center line of the old city, from Changpuak Gate to Chaing Mai Gate. The temple is just a short walk south of the intersection with the main east-west Ratchadamnoen Road.", initMember[0], cal.getTime(), true),
                new CommentForum(2l, "Round whitewashed columns support", initMember[1], cal.getTime(), true),
                new CommentForum(3l, "This comment has been removed by administrator due to maintain a conversation of the other members.", initMember[2], cal.getTime(), false),
                new CommentForum(4l, "Whattttt, that's really cool", initMember[3], cal.getTime(), true)
        };

        CommentForum[] initCommentForums2 = {
                new CommentForum(5l, "Wat Chedi Luang is on Prapokklao Road which runs roughly through the north-south center line of the old city, from Changpuak Gate to Chaing Mai Gate. The temple is just a short walk south of the intersection with the main east-west Ratchadamnoen Road.", initMember[0], cal.getTime(), true),
                new CommentForum(6l, "Round whitewashed columns support", initMember[1], cal.getTime(), true),
                new CommentForum(7l, "Huh, that's really cool", initMember[2], cal.getTime(), true),
                new CommentForum(8l, "Whattttt, that's really cool", initMember[3], cal.getTime(), true),
                new CommentForum(9l, "This comment has been removed by administrator due to maintain a conversation of the other members.", initMember[0], cal.getTime(), false)
        };

        CommentForum[] initCommentForums3 = {
                new CommentForum(10l, "Round whitewashed columns support", initMember[1], cal.getTime(), true),
                new CommentForum(11l, "Huh, that's really cool", initMember[2], cal.getTime(), true),
                new CommentForum(12l, "Whattttt, that's really cool", initMember[3], cal.getTime(), true),
                new CommentForum(13l, "Wat Chedi Luang is on Prapokklao Road which runs roughly through the north-south center line of the old city, from Changpuak Gate to Chaing Mai Gate. The temple is just a short walk south of the intersection with the main east-west Ratchadamnoen Road.", initMember[0], cal.getTime(), true),
                new CommentForum(14l, "Round whitewashed columns support", initMember[1], cal.getTime(), true)
        };

        CommentForum[] initCommentForums4 = {
                new CommentForum(15l, "Huh, that's really cool", initMember[2], cal.getTime(), true),
                new CommentForum(16l, "Whattttt, that's really cool", initMember[3], cal.getTime(), true),
                new CommentForum(17l, "Wat Chedi Luang is on Prapokklao Road which runs roughly through the north-south center line of the old city, from Changpuak Gate to Chaing Mai Gate. The temple is just a short walk south of the intersection with the main east-west Ratchadamnoen Road.", initMember[0], cal.getTime(), true),
                new CommentForum(18l, "Round whitewashed columns support", initMember[1], cal.getTime(), true),
                new CommentForum(19l, "Wat Chedi Luang is on Prapokklao Road which runs roughly through the north-south center line of the old city, from Changpuak Gate to Chaing Mai Gate. The temple is just a short walk south of the intersection with the main east-west Ratchadamnoen Road.", initMember[0], cal.getTime(), true),
                new CommentForum(20l, "Round whitewashed columns support", initMember[1], cal.getTime(), true),
        };

        List<CommentForum> commentForumList = new ArrayList<>();
        commentForumList.addAll(Arrays.asList(initCommentForums1));
        commentForumList.addAll(Arrays.asList(initCommentForums2));
        commentForumList.addAll(Arrays.asList(initCommentForums3));
        commentForumList.addAll(Arrays.asList(initCommentForums4));

        commentForumRepository.save(commentForumList);

        Forum[] initForum ={
                new Forum(1l,"Where is Wat Chedi Luang?", "I want to know the exact location od this place", initMember[0], Arrays.asList(initCommentForums1), cal.getTime(),1),
                new Forum(2l,"How can I get there?","I will arrived Chiang Mai next week and I will stay at Nimman Hotel. Can you recommend me how to go there please?", initMember[1],Arrays.asList(initCommentForums2), cal.getTime(),1),
                new Forum(3l,"Is this temple is the main temple of Chiang Mai?", "I going to write an academic essay about temple in Chiang Mai and I interested in Wat Chedi Luang. I want to know the information about this temple. Thank you", initMember[2], Arrays.asList(initCommentForums3), cal.getTime(),1),
                new Forum(4l,"Any tourist attraction near Wat Chedi Luang?", "I will go there next week but I don't know the place that I can visit after Wat Chedi Luang. Can someone recommend me the place?", initMember[3], Arrays.asList(initCommentForums4), cal.getTime(),1),
        };

        forumRepository.save(Arrays.asList(initForum));
    }
}