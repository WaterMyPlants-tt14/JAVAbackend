package com.lambdaschool.foundation;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.lambdaschool.foundation.models.*;
import com.lambdaschool.foundation.services.PlantService;
import com.lambdaschool.foundation.services.RoleService;
import com.lambdaschool.foundation.services.SpeciesService;
import com.lambdaschool.foundation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

/**
 * SeedData puts both known and random data into the database. It implements CommandLineRunner.
 * <p>
 * CoomandLineRunner: Spring Boot automatically runs the run method once and only once
 * after the application context has been loaded.
 */
@Transactional
@ConditionalOnProperty(
    prefix = "command.line.runner",
    value = "enabled",
    havingValue = "true",
    matchIfMissing = true)
@Component
public class SeedData
    implements CommandLineRunner
{
    /**
     * Connects the Role Service to this process
     */
    @Autowired
    RoleService roleService;

    /**
     * Connects the user service to this process
     */
    @Autowired
    UserService userService;

    @Autowired
    SpeciesService speciesService;

    @Autowired
    PlantService plantService;

    /**
     * Generates test, seed data for our application
     * First a set of known data is seeded into our database.
     * Second a random set of data using Java Faker is seeded into our database.
     * Note this process does not remove data from the database. So if data exists in the database
     * prior to running this process, that data remains in the database.
     *
     * @param args The parameter is required by the parent interface but is not used in this process.
     */
    @Transactional
    @Override
    public void run(String[] args) throws
                                   Exception
    {
        userService.deleteAll();
        roleService.deleteAll();
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        r1 = roleService.save(r1);
        r2 = roleService.save(r2);
        r3 = roleService.save(r3);

        // admin, data, user
        User u1 = new User("admin",
            "password",
            "admin@lambdaschool.local",
            "1111",
            "Taylor");
        u1.getRoles()
            .add(new UserRoles(u1,
                r1));
        u1.getRoles()
            .add(new UserRoles(u1,
                r2));
        u1.getRoles()
            .add(new UserRoles(u1,
                r3));
        u1.getUseremails()
            .add(new Useremail(u1,
                "admin@email.local"));
        u1.getUseremails()
            .add(new Useremail(u1,
                "admin@mymail.local"));

        u1 = userService.save(u1);

        // data, user
        User u2 = new User("cinnamon",
            "1234567",
            "cinnamon@lambdaschool.local",
            "2222",
            "Cinnamon");
        u2.getRoles()
            .add(new UserRoles(u2,
                r2));
        u2.getRoles()
            .add(new UserRoles(u2,
                r3));
        u2.getUseremails()
            .add(new Useremail(u2,
                "cinnamon@mymail.local"));
        u2.getUseremails()
            .add(new Useremail(u2,
                "hops@mymail.local"));
        u2.getUseremails()
            .add(new Useremail(u2,
                "bunny@email.local"));
        userService.save(u2);

        Species s1 = new Species();
        s1.setPlant_name("Fiddle Leaf Fig");
        s1.setPlant_scientific_name("Ficus Lyrata");
        s1.setPlant_image("https://bloomscape.com/wp-content/uploads/2020/08/bloomscape_fiddle-leaf-fig_charcoal-alt.jpg?ver=279576");
        s1.setWater_schedule("Once Per Week");
        speciesService.save(s1);

        Species s2 = new Species();
        s2.setPlant_name("Golden Barrel Cactus");
        s2.setPlant_scientific_name("Echinocactus grusonii");
        s2.setPlant_image("https://bloomscape.com/wp-content/uploads/2021/03/bloomscape_cacti-golden-barrell_medium_clay.jpg?ver=425501");
        s2.setWater_schedule("Every 14 Days");
        speciesService.save(s2);

        Species s3 = new Species();
        s3.setPlant_name("Hedgehog Aloe");
        s3.setPlant_scientific_name("Aloe vera");
        s3.setPlant_image("https://bloomscape.com/wp-content/uploads/2020/08/bloomscape_hedgehog-aloe_charcoal.jpg?ver=278997");
        s3.setWater_schedule("Every 14 Days");
        speciesService.save(s3);

        Species s4 = new Species();
        s4.setPlant_name("Kimberly Queen Fern");
        s4.setPlant_scientific_name("Nephrolepis obliterata");
        s4.setPlant_image("https://bloomscape.com/wp-content/uploads/2020/08/bloomscape_kimberly-queen-fern_charcoal.jpg?ver=279236");
        s4.setWater_schedule("Twice Per Week");
        speciesService.save(s4);

        Species s5 = new Species();
        s5.setPlant_name("Rubber Tree");
        s5.setPlant_scientific_name("Ficus Elastica");
        s5.setPlant_image("https://bloomscape.com/wp-content/uploads/2020/12/bloomscape_burgandy-rubber-tree_stone-resize.jpg?ver=372943");
        s5.setWater_schedule("Once Per Week");
        speciesService.save(s5);

        Species s6 = new Species();
        s6.setPlant_name("Snake Plant");
        s6.setPlant_scientific_name("Sanseviera ");
        s6.setPlant_image("https://bloomscape.com/wp-content/uploads/2020/12/bloomscape_sansevieria_stone-resize.jpg?ver=372956");
        s6.setWater_schedule("Every 14 Days");
        speciesService.save(s6);

        Species s7 = new Species();
        s7.setPlant_name("Spider Plant");
        s7.setPlant_scientific_name("Chlorophytum comosum");
        s7.setPlant_image("https://bloomscape.com/wp-content/uploads/2020/08/bloomscape-spider-plant_stone.jpg?ver=279117");
        s7.setWater_schedule("Once Per Week");
        speciesService.save(s7);

        Species s8 = new Species();
        s8.setPlant_name("Staggered Yucca Cane");
        s8.setPlant_scientific_name("Yucca elephantipes");
        s8.setPlant_image("https://bloomscape.com/wp-content/uploads/2021/03/bloomscape_yucca-cane_xl_clay.jpg?ver=437482");
        s8.setWater_schedule("Every 14 Days");
        speciesService.save(s8);

        Species s9 = new Species();
        s9.setPlant_name("Neon Rubber Tree");
        s9.setPlant_scientific_name("Ficus Altissima");
        s9.setPlant_image("https://bloomscape.com/wp-content/uploads/2020/05/bloomscape_ficus-altissima-std_charcoal.jpg?ver=385169");
        s9.setWater_schedule("Once Per Week");
        speciesService.save(s9);

        Species s10 = new Species();
        s10.setPlant_name("Parlor Palm");
        s10.setPlant_scientific_name("Chamaedorea elegans");
        s10.setPlant_image("https://bloomscape.com/wp-content/uploads/2020/08/bloomscape_parlor-palmloomscape_charcoal.jpg?ver=279260");
        s10.setWater_schedule("Once Per Week");
        speciesService.save(s10);

        Species s11 = new Species();
        s11.setPlant_name("Philodendron Heart Leaf");
        s11.setPlant_scientific_name("Philodendron selloum");
        s11.setPlant_image("https://bloomscape.com/wp-content/uploads/2020/08/bloomscape_philodendron-heartleaf_charcoal.jpg?ver=279047");
        s11.setWater_schedule("Twice Per Week");
        speciesService.save(s11);

        Species s12 = new Species();
        s12.setPlant_name("Ponytail Palm");
        s12.setPlant_scientific_name("Beaucarnea Recurvata");
        s12.setPlant_image("https://bloomscape.com/wp-content/uploads/2020/04/bloomscape_palm-ponytail_slate_lg-scaled.jpg?ver=439957");
        s12.setWater_schedule("Every 14 Days");
        speciesService.save(s12);

        Species s13 = new Species();
        s13.setPlant_name("Pothos");
        s13.setPlant_scientific_name("Epipremnum");
        s13.setPlant_image("https://bloomscape.com/wp-content/uploads/2020/08/bloomscape_pothos_collection_pearls-jade.jpg?ver=278897");
        s13.setWater_schedule("Every 14 Days");
        speciesService.save(s13);

        Species s14 = new Species();
        s14.setPlant_name("Prayer Plant");
        s14.setPlant_scientific_name("Maranta leuconeur");
        s14.setPlant_image("https://bloomscape.com/wp-content/uploads/2020/09/bloomscape_neon-prayer-plant_charcoal.jpg?ver=292318");
        s14.setWater_schedule("Once Per Week");
        speciesService.save(s14);

        Species s15 = new Species();
        s15.setPlant_name("Succulent");
        s15.setPlant_scientific_name("Succulent");
        s15.setPlant_image("https://bloomscape.com/wp-content/uploads/2020/10/bloomscape_jack-frost_collection_terra-cotta.jpg?ver=313682");
        s15.setWater_schedule("Once Per Week");
        speciesService.save(s15);


        Plant p1 = new Plant();
        p1.setPlant_nickname("My favorite fern");
        p1.setPlant_location("front door");
        p1.setWater_day(2);
        p1.setNotes("Sally gave me this plant");
        p1.setSpecies(s2);
        p1.setUser(u1);
        plantService.save(p1);

    }
}