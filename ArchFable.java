import java.util.*;


//HERO CLASS DEFINED AHEAD
class Hero
{
    private final String HeroType;
    private Double HP;
    private int XP;
    private int Current_level;
    private boolean Special_attack;
    private boolean Special_usable;
    private int moves_since_last_special;
    private int Base_attack;
    private int Base_defense;
    private boolean Defending;
    private int hero_level;
    private int max_hp;

    /**
     * @return the max_hp
     */
    public int getMax_hp() {
        return max_hp;
    }

    /**
     * @param max_hp the max_hp to set
     */
    public void setMax_hp(int max_hp) {
        this.max_hp = max_hp;
    }


    public void Reset_hero()
    {
        this.HP = Double.parseDouble( String.valueOf(100) );
        this.XP = 0;
        this.Current_level=1;
        this.Special_attack = false;
        this.Special_usable = false;
        this.moves_since_last_special = 0;
        this.Defending=false;
        this.hero_level = 1;
        this.max_hp=100;
    }




    //PUTTING GETTERS AND SETTERS


    /**
     * @return the hero_level
     */
    public int getHero_level() {
        return hero_level;
    }

    /**
     * @param hero_level the hero_level to set
     */
    public void setHero_level(int hero_level) {
        this.hero_level = hero_level;
    }


    /**
     * @return the special_usable
     */
    public boolean isSpecial_usable() {
        return Special_usable;
    }

    /**
     * @param moves_since_last_special the moves_since_last_special to set
     */
    public void setMoves_since_last_special(int Moves_since_last_special) {
        this.moves_since_last_special = Moves_since_last_special;
        if(this.moves_since_last_special==3)
        {
            this.Special_usable=true;
            this.moves_since_last_special=0;
            this.setSpecial_attack(false);
        }
    }

    /**
     * @param defending the defending to set
     */
    public void setDefending(boolean defending) {
        Defending = defending;
    }

    /**
     * @param special_attack the special_attack to set
     */
    public void setSpecial_attack(boolean special_attack) {
        Special_attack = special_attack;
    }

    /**
     * @param special_usable the special_usable to set
     */
    public void setSpecial_usable(boolean special_usable) {
        Special_usable = special_usable;
    }

    /**
     * @return the moves_since_last_special
     */
    public int getMoves_since_last_special() {
        return moves_since_last_special;
    }


    /**
     * @return the base_attack
     */
    public int getBase_attack() {
        return Base_attack;
    }

    /**
     * @return the defending
     */
    public boolean isDefending() {
        return Defending;
    }

    /**
     * @return the base_defense
     */
    public int getBase_defense() {
        return Base_defense;
    }

    /**
     * @param base_attack the base_attack to set
     */
    public void setBase_attack(int base_attack) {
        Base_attack = base_attack;
    }

    /**
     * @param base_defense the base_defense to set
     */
    public void setBase_defense(int base_defense) {
        Base_defense = base_defense;
    }

    /**
     * @return the current_level
     */
    public int getCurrent_level() {
        return Current_level;
    }

    /**
     * @return the special_attack
     */
    public boolean isSpecial_attack() {
        return Special_attack;
    }

    /**
     * @return the hP
     */
    public Double getHP() {
        return HP;
    }
    
    /**
     * @return the HeroType
     */
    public String getHeroType() {
        return HeroType;
    }

    /**
     * @return the xP
     */
    public int getXP() {
        return XP;
    }

    /**
     * @param xP the xP to set
     */
    public void setXP(int xP) {
        XP = xP;
        if(this.getXP() >=20 && this.getXP()<60)
        {
            //hero leveled up to level 2
            this.setHero_level(2);
            this.setHP( Double.parseDouble( String.valueOf(150) ) );
            this.setMax_hp(150);
            System.out.println("Level UP: level 2");
        }
        else if(this.getXP()>=60 && this.getXP()<120)
        {
            //hero is now level 3
            this.setHero_level(3);
            this.setHP( Double.parseDouble( String.valueOf(200) ) );
            this.setMax_hp(200);
            System.out.println("Level UP: level 3");
        }
        else if(this.getXP()>=120)
        {
            this.setHero_level(4);
            this.setHP( Double.parseDouble( String.valueOf(250) ) );
            this.setMax_hp(250);
            System.out.println("Level UP: level 4");
        }
    }

    /**
     * @param current_level the current_level to set
     */
    public void setCurrent_level(int current_level) {
        Current_level = current_level;
    }

    /**
     * @param hP the hP to set
     */
    public void setHP(Double hP) {
        HP = hP;
    }


    Hero(String heroType)
    {
        this.HeroType = heroType.toLowerCase();
        this.Current_level = 1;
        this.HP = Double.parseDouble( String.valueOf(100) );
        this.XP = 0;
        this.Special_attack = false;
        this.moves_since_last_special = 0;
        this.Defending = false;
        this.Special_usable=false;
        this.Special_attack=false;
        this.max_hp=100;
    }

    /**
     * Changes the HP of monster and hero in accordance to the type of attack,
     * The type of Hero and the use of special power
     * @param myhero
     * @param mymonster
     */
    
     public void AttackMonster(Hero myhero, Monster mymonster)
    {
        Double newMonsterhp = mymonster.getHP()-(myhero.getBase_attack());
        //check if the attacking hero is warrior
        if(myhero.getHeroType().toLowerCase().equals("Warrior".toLowerCase()) && isSpecial_attack())
        {
            System.out.println("Base attack boosted by 5, Special attack is being used");
            //The selected Hero is warrior and is attacking with special power activated
                newMonsterhp -= 5;
        }
        //check if the attacking hero is a Mage
        else if(myhero.getHeroType().toLowerCase().equals("Mage".toLowerCase()) && isSpecial_attack())
        {
            System.out.println("Opponents HP reduced by "+ ( newMonsterhp*0.05 ) +" due to special power");
            newMonsterhp = newMonsterhp*0.95;
        }
        //check if the attacking Hero is a Theif
        else if(myhero.getHeroType().toLowerCase().equals("Thief".toLowerCase()) && isSpecial_attack())
        {
            myhero.setHP( myhero.getHP() + newMonsterhp*0.30 );
            newMonsterhp = newMonsterhp*0.70;
        }
        //check if the attacking hero is Healer
        else if(myhero.getHeroType().toLowerCase().equals("Healer".toLowerCase()) && isSpecial_attack())
        {
            System.out.println("Your HP increased by "+( myhero.getHP()*0.05 )+" due to Special power");
            myhero.setHP(myhero.getHP()*1.05);
        }
        
        System.out.println("You attacked and inflicted "+(mymonster.getHP()-newMonsterhp)+" damage to the monster");
        mymonster.setHP(newMonsterhp);
        System.out.println("Your HP: "+myhero.getHP()+"/"+myhero.getMax_hp() +" Monster HP: "+ mymonster.getHP()+"/"+mymonster.getMax_hp());
        
    }
}


class Warrior extends Hero
{    
    /**
     * 
     * @param heroType
     */
    Warrior(String heroType)
    {
        super(heroType);
        super.setBase_attack(10);
        super.setBase_defense(3);
    }

    @Override
    public void Reset_hero() {
        super.Reset_hero();
        super.setBase_attack(10);
        super.setBase_defense(3);
    }

}

class Mage extends Hero
{   
    /**
     * 
     * @param heroType
     */
    Mage(String heroType)
    {
        super(heroType);
        super.setBase_attack(5);
        super.setBase_defense(5);
    }

    @Override
    public void Reset_hero() {
        super.Reset_hero();
        super.setBase_attack(5);
        super.setBase_defense(5);
    }

}

class Thief extends Hero
{   
    /**
     * 
     * @param heroType
     */
    Thief(String heroType)
    {
        super(heroType);
        super.setBase_attack(6);
        super.setBase_defense(4);
    }
    
    //think over this function, it will implement polymorphism
    @Override
    public void setMoves_since_last_special(int Moves_since_last_special) {
        super.setMoves_since_last_special(Moves_since_last_special);
        if(Moves_since_last_special==1)
        {
            super.setSpecial_attack(false);
        }
    }

    @Override
    public void Reset_hero() {
        super.Reset_hero();
        super.setBase_attack(6);
        super.setBase_defense(4);
    }
}

class Healer extends Hero
{   
    /**
     * 
     * @param heroType
     */
    Healer(String heroType)
    {
        super(heroType);
        super.setBase_attack(4);
        super.setBase_defense(8);
    }

    @Override
    public void Reset_hero() {
        super.Reset_hero();
        super.setBase_attack(4);
        super.setBase_defense(8);
    }
}

class Monster
{
    private Double HP;
    private Double max_hp;
    private final int level;

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }
    
    /**
     * @return the hP
     */
    public Double getHP() {
        return HP;
    }

    /**
     * @param hP the hP to set
     */
    public void setHP(Double hP) {
        HP = hP;
    }

    /**
     * @return the max_hp
     */
    public Double getMax_hp() {
        return max_hp;
    }

    /**
     * @param max_hp the max_hp to set
     */
    public void setMax_hp(Double max_hp) {
        this.max_hp = max_hp;
    }

   

    
    public Double getMonsterAttackValue( Double hp )
    {
        Random rand = new Random();
        Double constraint = hp/4;
        Double attack = (Double)rand.nextGaussian();

        while( attack<-1 || attack>1 )
        {
            attack = (Double)rand.nextGaussian();
        }

        return (Double)(Math.abs((double)attack)*constraint);
    }

    Monster(int mylevel)
    {
        this.level = mylevel;
        switch(mylevel)
        {
            case 1 : this.HP = Double.parseDouble( String.valueOf(100) );
                    break;
            case 2 : this.HP = Double.parseDouble( String.valueOf(100) );
                    break;
            case 3 : this.HP = Double.parseDouble( String.valueOf(200) );
                    break;
            case 4 : this.HP = Double.parseDouble( String.valueOf(250) );
                    break;
        }
    }


    public void attackHero( Hero myHero, Monster myMonster )
    {
        Double monster_attack_value = getMonsterAttackValue(myMonster.getHP());
        //if the monster is LIONFANG
        //accomodate his special attack 
        boolean LionFang = false;

        if(myMonster.getLevel()==4)
        {
            LionFang = true;
            //The monster is LIONFANG
            Random rand = new Random();
            int x = rand.nextInt(10);
            if(x==2)
            {
                //THis happens with 1/10 probablility
                monster_attack_value = (Double)((Double)myHero.getHP()*0.5);
            }
        }

        if(LionFang)
        {
            System.out.println("LionFang Attacks!");
        }
        else
        {
            System.out.println("Monster Attacks");
        }

        Double final_attack_val = monster_attack_value;
        if(myHero.isDefending())
        {
            //The hero is defending, get its base Defense
            int defended_Value = myHero.getBase_defense();
            Double net_attack = monster_attack_value - defended_Value;

            //check the type of hero being acted on and the applicability of any special power
            if(myHero.getHeroType().toLowerCase().equals("Warrior".toLowerCase()) && myHero.isSpecial_attack())
            {
                net_attack -= 5;
            }
            else if(myHero.getHeroType().toLowerCase().equals("Mage".toLowerCase()) && myHero.isSpecial_attack())
            {
                myMonster.setHP( (Double)(myMonster.getHP()*0.95) );
            }
            else if(myHero.getHeroType().toLowerCase().equals("Theif".toLowerCase()) && myHero.isSpecial_attack())
            {
                //increase the hero HP
                myHero.setHP( myHero.getHP()+(myMonster.getHP()*0.30) );
                //Decrease the Monster HP by 30%
                myMonster.setHP( myMonster.getHP()*0.70 );
            }
            else if(myHero.getHeroType().toLowerCase().equals("Healer".toLowerCase()) && myHero.isSpecial_attack())
            {
                //increase your own HP 
                myHero.setHP( (Double)(myHero.getHP()*1.05) );
            }

            if(net_attack>0)
            {
                //The net attack is non negative meaning that the hero has taken some amount of damage
                final_attack_val = net_attack;
            }
        }
        if(LionFang)
        {
            System.out.println("Lionfang inflicted "+final_attack_val+" Damage");
        }
        else
        {
            System.out.println("Monster innflicted "+final_attack_val+" Damage");
        }
        //change the HP of hero And monster respectively
        
        myHero.setHP( (Double)(myHero.getHP() - final_attack_val) );
        System.out.println("Your HP: "+myHero.getHP()+"/"+myHero.getMax_hp() +" Monster HP: "+ myMonster.getHP()+"/"+myMonster.getMax_hp());
    }

}


class Goblin extends Monster
{
    Goblin()
    {
        super(1);
        super.setMax_hp( Double.parseDouble( String.valueOf(100) ) );
    }
}


class Zombie extends Monster
{
    Zombie()
    {
        super(2);
        super.setMax_hp( Double.parseDouble( String.valueOf(100) ) );
    }
}


class Fiend extends Monster
{
    Fiend()
    {
        super(3);
        super.setMax_hp( Double.parseDouble( String.valueOf(200) ) );
    }
}


class LionFang extends Monster
{
    LionFang()
    {
        super(4);
        super.setMax_hp( Double.parseDouble( String.valueOf(250) ) );
    }
}



//PLAYER CLASS DEFINED AHEAD
class Player
{
    private final Hero myHero;
    private final String UserName;
    private Location current_location;
    private ArrayList<Location> Path_taken;

    Player(String usrname, Hero hero)
    {
        this.myHero = hero;
        this.UserName = usrname;
        this.current_location = null;
        this.Path_taken = new ArrayList<Location>();
    }

    /**
     * @return the path_taken
     */
    public ArrayList<Location> getPath_taken() {
        return Path_taken;
    }

    /**
     * @return the current_location
     */
    public Location getCurrent_location() {
        return current_location;
    }

    /**
     * @return the myHero
     */
    public Hero getMyHero() {
        return myHero;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return UserName;
    }

    /**
     * @param current_location the current_location to set
     */
    public void setCurrent_location(Location current_location) {
        this.current_location = current_location;
    }

}


//Create a class to keep track of locations
class Location
{
    private Monster local_monster;
    private int Location_number;

    Location(int num)
    {
        this.Location_number = num;
        Random rand = new Random();
        num = rand.nextInt(9);
        switch(num)
        {
            case 0:
            case 1:
            case 2: local_monster = new Goblin();
                    break;
            case 3:
            case 4:
            case 5: local_monster = new Fiend();
                    break;
            case 6:
            case 7:
            case 8: local_monster = new Zombie();
                    break;
        }

        if(this.Location_number==10)
        {
            //This is the location for LionFang
            local_monster = new LionFang();
        }
    }

    /**
     * @return the local_monster
     */
    public Monster getLocal_monster() {
        return local_monster;
    }

    /**
     * @return the location_number
     */
    public int getLocation_number() {
        return Location_number;
    }

}


class GameplayEngine
{
    ArrayList<Location> availaible_locs = new ArrayList<Location>();
    HashMap<Location, Integer> location_numbers_to_display = new HashMap<Location, Integer>();
    HashMap<Integer, Location> Number_displayed_to_Location = new HashMap<Integer, Location>();
    ArrayList<Player> players = new ArrayList<Player>();


    /**
     * Initialize the gameplay variables for the Player p
     * initialize the Locations, Set current location of player to starting location 0
     * @param p : player for which the engine is initialized
     */
    public void initialize_Engine(Player p)
    {
        for ( int i=0; i<11; i++ )
        {
            Location L = new Location(i);
            availaible_locs.add(L);
            
            //set the current location of this player as the start Location
            if(L.getLocation_number()==0)
            {
                p.setCurrent_location(L);
            }
        }

        boolean[] usedNumbers = new boolean[11];
        Random rand = new Random();
        int i=0;
        //Now set the values of the next nodes that are visible from each node
        while(i!=availaible_locs.size())
        {
            int x = rand.nextInt(11);
            if(usedNumbers[x]==false)
            {
                location_numbers_to_display.put( availaible_locs.get(i) ,x);
                Number_displayed_to_Location.put(x, availaible_locs.get(i));
                usedNumbers[x]=true;
                i+=1;
            } 
        }

    }

    public void Display_Startup_menu()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to ArchLegends");
        System.out.println("Choose your option");
        System.out.println("1) New User");
        System.out.println("2) Existing User");
        System.out.println("3) Exit");
        int user_choice = Integer.parseInt(sc.nextLine());
        switch(user_choice)
        {
            case 1: Register_new_user();
                    break;
            case 2: //Existing user
                    //login with username and then use the corresponding player instance to
                    //play the game
                    Existing_User_login();
                    break;
            case 3: System.exit(0);
                    break;
            default://Error Handling
                    System.out.println("ERROR : Please Enter A valid option!");
                    Display_Startup_menu();
                    break;
            
        }

    }

    public int Fight_monster_at_current_location(Player p)
    {
        Scanner sc = new Scanner(System.in);
        Double init_hero_hp = p.getMyHero().getHP();
        boolean win = false;
        System.out.println();
        System.out.println("Fight Started. You are fighting a level "+p.getCurrent_location().getLocal_monster().getLevel()+" Monster");
        while(p.getMyHero().getHP()>0 && p.getCurrent_location().getLocal_monster().getHP()>0)
        {
            //this loop runs while the monster and the Hero both have Health Points greater than 0
            System.out.println("Choose Move");
            System.out.println("1) Attack");
            System.out.println("2) Defense");
            if(p.getMyHero().isSpecial_usable())
            {
                System.out.println("3) Special Attack");
            }
            //implement the counter for the Special attack
            int user_choice = Integer.parseInt(sc.nextLine());
            switch(user_choice)
            {
                case 1://The user chose to attack
                        System.out.println("You choose to Attack");
                        p.getMyHero().AttackMonster(p.getMyHero(), p.getCurrent_location().getLocal_monster());
                        p.getMyHero().setMoves_since_last_special(p.getMyHero().getMoves_since_last_special()+1);
                        break;
                case 2://The user chose to Defend
                        p.getMyHero().setDefending(true);
                        p.getMyHero().setMoves_since_last_special(p.getMyHero().getMoves_since_last_special()+1);
                        break;
                case 3:if(p.getMyHero().isSpecial_usable())
                        {
                            p.getMyHero().setSpecial_attack(true);
                            p.getMyHero().setSpecial_usable(false);
                            System.out.println("Special power activated");
                            System.out.println("Performing Special attack");
                            if( p.getMyHero().getHeroType().toLowerCase().equals("Thief".toLowerCase()))
                            {
                                //thif used his special attack
                                System.out.println("You have stolen "+ p.getCurrent_location().getLocal_monster().getHP()*0.30 + " HP from the Monster");
                            }
                        }
                        else
                        {
                            System.out.println("Special attack currently not usable");
                            continue;
                        }
            }
           
            if(p.getCurrent_location().getLocal_monster().getHP()<=0)
            {
                //The monster is dead
                //Increase Hero XP
                //Increase hero Base levels
                //set win to True
                //Reset the monster HP
                System.out.println("Monster Killed");
                System.out.println( p.getCurrent_location().getLocal_monster().getLevel()*20 + " XP awarded" );
                p.getMyHero().setXP( p.getMyHero().getXP() + (20*p.getCurrent_location().getLocal_monster().getLevel()));
                win = true;
                Double monHP = Double.parseDouble( String.valueOf(0) );
                switch( p.getCurrent_location().getLocal_monster().getLevel())
                {
                    case 1:
                    case 2: monHP = Double.parseDouble( String.valueOf(100) );
                            break;
                    case 3: monHP = Double.parseDouble( String.valueOf(200) );
                    case 4: monHP = Double.parseDouble( String.valueOf(250) );
                }
                p.getCurrent_location().getLocal_monster().setHP(monHP);
                p.getMyHero().setHP( Double.parseDouble( String.valueOf( p.getMyHero().getMax_hp()) ) );
                break;
            }
            
            //Now the monster attacks;
            p.getCurrent_location().getLocal_monster().attackHero( p.getMyHero(),  p.getCurrent_location().getLocal_monster());

            if(p.getMyHero().getHP()<=0)
            {
                //you lost
                win = false;
                System.out.println("You Lost The Fight, Resetting the gameplay ");
                //reset the state of the monster
                Double monHP = Double.parseDouble( String.valueOf(0) );
                switch( p.getCurrent_location().getLocal_monster().getLevel())
                {
                    case 1:
                    case 2: monHP = Double.parseDouble( String.valueOf(100) );
                            break;
                    case 3: monHP = Double.parseDouble( String.valueOf(200) );
                    case 4: monHP = Double.parseDouble( String.valueOf(250) );
                }
                p.getCurrent_location().getLocal_monster().setHP(monHP);
                //reset the state of the Hero
                p.getMyHero().Reset_hero();
                //send hero to location 0
                p.setCurrent_location(availaible_locs.get(0));
                break;
            }

            

        }

        if(win)
            {
                return 1;
            }
            return -1;
    }

    public void Play_Game(Player p)
    {
        Scanner sc = new Scanner(System.in);
        if(p.getCurrent_location().getLocation_number()==0)
        {
            //player is at the starting location, ask for new loc
            System.out.println("You are at the starting location. Choose path:");
            System.out.println("1) Go to Location "+location_numbers_to_display.get(availaible_locs.get(1)));
            System.out.println("2) Go to Location "+location_numbers_to_display.get(availaible_locs.get(2)));
            System.out.println("3) Go to Location "+location_numbers_to_display.get(availaible_locs.get(3)));
            System.out.println("Enter -1 to Exit");
            int whereTo = Integer.parseInt(sc.nextLine());

            int dec;
            if(whereTo==-1)
            {
                System.out.println("Exiting... ");
                System.exit(0);   
            }
            switch(whereTo)
            {
                case -1:System.out.println("Exiting... ");
                        System.exit(0);
                        break;
                case 1: p.getPath_taken().add(p.getCurrent_location());
                        p.setCurrent_location( Number_displayed_to_Location.get( location_numbers_to_display.get(availaible_locs.get(1))) ) ;
                        break;
                case 2: p.getPath_taken().add(p.getCurrent_location());
                        p.setCurrent_location( Number_displayed_to_Location.get( location_numbers_to_display.get(availaible_locs.get(2))) ) ;
                        break;
                case 3: p.getPath_taken().add(p.getCurrent_location());
                        p.setCurrent_location( Number_displayed_to_Location.get( location_numbers_to_display.get(availaible_locs.get(3))) ) ;
                        break;
            }

            dec = Fight_monster_at_current_location(p);
            if(dec==1)
            {
                //you won the fight
                //recall this function
                Play_Game(p);
            }
            else if(dec==-1)
            {
                //you Lost the battle
                Display_Startup_menu();
            }
        }

        else
        {
            int dec = 0;

            //The current Location is not the starting location
            //check_location_number and display the appropriate options to the user to choose From
            int check_loc_number = p.getCurrent_location().getLocation_number();
            if(check_loc_number==1 || check_loc_number==2 || check_loc_number==3)
            {
                //user is at location 1, 2 or 3
                System.out.println("You are at location "+check_loc_number+" Choose path:");
                System.out.println("1) Go to location "+location_numbers_to_display.get(availaible_locs.get(4)));
                System.out.println("2) Go to location "+location_numbers_to_display.get(availaible_locs.get(5)));
                System.out.println("3) Go to location "+location_numbers_to_display.get(availaible_locs.get(6)));
                System.out.println("4) Go back");
                System.out.println("Enter -1 to exit");
                int whereTo = Integer.parseInt(sc.nextLine());
                switch(whereTo)
                {
                    //implement the change loc menu
                    case 1: //go to loc 4
                            p.getPath_taken().add(p.getCurrent_location());
                            p.setCurrent_location( Number_displayed_to_Location.get( location_numbers_to_display.get(availaible_locs.get(4))) ) ;
                            break;
                    case 2://go to loc 5
                            p.getPath_taken().add(p.getCurrent_location());
                            p.setCurrent_location( Number_displayed_to_Location.get( location_numbers_to_display.get(availaible_locs.get(5))) ) ;
                            break;
                    case 3://go to loc 6
                            p.getPath_taken().add(p.getCurrent_location());
                            p.setCurrent_location( Number_displayed_to_Location.get( location_numbers_to_display.get(availaible_locs.get(3))) ) ;
                            break;
                    case 4://Implemet GO BACK
                            p.setCurrent_location(p.getPath_taken().get(p.getPath_taken().size()-1));
                            p.getPath_taken().remove(p.getPath_taken().size()-1);
                            break;
                    default:System.out.println("Please Choose a valid option");
                            Play_Game(p);
                            break;
                }
            }



            if(check_loc_number==4 || check_loc_number==5 || check_loc_number==6)
            {
                //user is at location 1, 2 or 3
                System.out.println("You are at location "+check_loc_number+" Choose path:");
                System.out.println("1) Go to location "+location_numbers_to_display.get(availaible_locs.get(7)));
                System.out.println("2) Go to location "+location_numbers_to_display.get(availaible_locs.get(8)));
                System.out.println("3) Go to location "+location_numbers_to_display.get(availaible_locs.get(9)));
                System.out.println("4) Go back");
                System.out.println("Enter -1 to exit");
                int whereTo = Integer.parseInt(sc.nextLine());
                switch(whereTo)
                {
                    //implement the change loc menu
                    case 1: //go to loc 7
                            p.getPath_taken().add(p.getCurrent_location());
                            p.setCurrent_location( Number_displayed_to_Location.get( location_numbers_to_display.get(availaible_locs.get(7))) ) ;
                            break;
                    case 2://go to loc 8
                            p.getPath_taken().add(p.getCurrent_location());
                            p.setCurrent_location( Number_displayed_to_Location.get( location_numbers_to_display.get(availaible_locs.get(8))) ) ;
                            break;
                    case 3://go to loc 9
                            p.getPath_taken().add(p.getCurrent_location());
                            p.setCurrent_location( Number_displayed_to_Location.get( location_numbers_to_display.get(availaible_locs.get(9))) ) ;
                            break;
                    case 4://Implemet GO BACK
                            p.setCurrent_location(p.getPath_taken().get(p.getPath_taken().size()-1));
                            p.getPath_taken().remove(p.getPath_taken().size()-1);
                            break;
                    default:System.out.println("Please Choose a valid option");
                            Play_Game(p);
                            break;
                }
            }

            
            if(check_loc_number==7 || check_loc_number==8 || check_loc_number==9)
            {
                //user is at location 1, 2 or 3
                Random rand = new Random();
                int loc1 = rand.nextInt(10);
                int loc2 = rand.nextInt(10);
                System.out.println("You are at location "+check_loc_number+" Choose path:");
                System.out.println("1) Go to location "+location_numbers_to_display.get(availaible_locs.get(10)));
                System.out.println("2) Go to location "+location_numbers_to_display.get(availaible_locs.get( loc1 )));
                System.out.println("3) Go to location "+location_numbers_to_display.get(availaible_locs.get( loc2 )));
                System.out.println("4) Go back");
                System.out.println("Enter -1 to exit");
                int whereTo = Integer.parseInt(sc.nextLine());
                switch(whereTo)
                {
                    //implement the change loc menu
                    case 1: //go to loc 4
                            p.getPath_taken().add(p.getCurrent_location());
                            p.setCurrent_location( Number_displayed_to_Location.get( location_numbers_to_display.get(availaible_locs.get(10))) ) ;
                            break;
                    case 2://go to loc 5
                            p.getPath_taken().add(p.getCurrent_location());
                            p.setCurrent_location( Number_displayed_to_Location.get( location_numbers_to_display.get(availaible_locs.get(loc1))) ) ;
                            break;
                    case 3://go to loc 6
                            p.getPath_taken().add(p.getCurrent_location());
                            p.setCurrent_location( Number_displayed_to_Location.get( location_numbers_to_display.get(availaible_locs.get(loc2))) ) ;
                            break;
                    case 4://Implemet GO BACK
                            p.setCurrent_location(p.getPath_taken().get(p.getPath_taken().size()-1));
                            p.getPath_taken().remove(p.getPath_taken().size()-1);
                            break;
                    default:System.out.println("Please Choose a valid option");
                            Play_Game(p);
                            break;
                }
            }


            dec = Fight_monster_at_current_location(p);
            if(dec==1)
            {
                //you won the fight
                //recall this function
                Play_Game(p);
            }
            else if(dec==-1)
            {
                //you Lost the battle
                Display_Startup_menu();
            }

        }
    }


    public void Existing_User_login()
    {
        System.out.println("Enter Username");
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        boolean user_logged_in = false;
        for( Player p : players )
        {
            if(p.getUserName().equals(userName))
            {
                //print record found and take him to play the game
                System.out.println("User Found... logging in");
                System.out.println("Welcome "+p.getUserName());
                user_logged_in = true;
                initialize_Engine(p);
                Play_Game(p);
            }
        }

        if(!user_logged_in)
        {
            System.out.println("No record of such user Found. Exiting");
            //empty feed taken, user record not found, log in again for Existing User
            Display_Startup_menu();
        }

    }



    public void Register_new_user()
    {
        System.out.println("Enter Username");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        System.out.println("Choose a Hero");
        System.out.println("1) Warrior");
        System.out.println("2) Thief");
        System.out.println("3) Mage");
        System.out.println("4) Healer");
        int hero_choice = Integer.parseInt(sc.nextLine());
        //Create a new Player with the apt Hero character
        String Hero_type = null;
        Hero myhero = null;
        Player new_player = null;
        switch(hero_choice)
        {
            case 1://Hero Chosen is Warrior
                     myhero = new Warrior("Warrior");
                     new_player = new Player(username, myhero);
                    players.add(new_player);
                    Hero_type = "Warrior";
                    break;
            case 2://Hero chosen is Thief
                     myhero = new Thief("Thief");
                     new_player = new Player(username, myhero);
                    players.add(new_player);
                    Hero_type = "Thief";
                    break;
            case 3://chosen hero is Mage
                     myhero = new Mage("Mage");
                     new_player = new Player(username, myhero);
                    players.add(new_player);
                    Hero_type = "Mage";
                    break;
            case 4://chosen hero is Healer
                    myhero = new Healer("Healer");
                    new_player = new Player(username, myhero);
                    players.add(new_player);
                    Hero_type = "Healer";
                    break;
        }

        System.out.println("User Creation done. Username: "+username+". Hero type: "+Hero_type+". Log in to play the game. Exiting");
        Display_Startup_menu();
    }

    public void start_game()
    {
        Display_Startup_menu();
    }
}


class ArchFable
{
    public static void main(String[] args) {
        GameplayEngine myGame = new GameplayEngine();
        myGame.start_game();
    }
}


