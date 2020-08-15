/*-----BASE DE DONNEES JAVA WEB-----*/
/*-----Script----*/

CREATE TABLE `dlivresdb`.CurrentLanguage(
	CurrentLanguage_ID varchar(2) PRIMARY KEY,
	NameLanguage varchar(100) NOT NULL
);
CREATE TABLE `dlivresdb`.Customer(
	Customer_ID integer auto_increment PRIMARY KEY,
    Username varchar(30) not null,
	Email varchar(255) NOT NULL UNIQUE,
	Name varchar(255) NOT NULL,
	FirstName varchar(255) NOT NULL,
	PhoneNumber varchar(255),
	BirthDate date NOT NULL,
	Street varchar(255) NOT NULL,
	StreetNumber integer NOT NULL CHECK(StreetNumber > 0),
	PostalCode integer NOT NULL CHECK (PostalCode > 999),
	City varchar(255) NOT NULL,
	Country varchar(255) NOT NULL,
	Password varchar(255) NOT NULL
    Authorities varchar(255) default null,
	NonExpired boolean not null,
	NonLocked boolean not null,
	CredentialNonExpired boolean not null,
	Enable boolean not null,
);

CREATE TABLE `dlivresdb`.Author(
	Author_ID integer auto_increment PRIMARY KEY,
	Name varchar(255) NOT NULL,
	FirstName varchar(255) NOT NULL
);
CREATE TABLE `dlivresdb`.PublishingHouse(
	PublishingHouse_ID integer auto_increment PRIMARY KEY,
	Wording varchar(255) NOT NULL
);
CREATE TABLE `dlivresdb`.Category(
	Category_ID integer auto_increment PRIMARY KEY
);

CREATE TABLE `dlivresdb`.Book(
	Isbn integer PRIMARY KEY,
	Price float NOT NULL CHECK (Price > 0),
	Summary varchar(255) NOT NULL,
	NumberOfPages integer NOT NULL CHECK(NumberOfPages > 0),
	PublicationDate date NOT NULL ,
	Height integer  CHECK(Height > 0),
	Width integer CHECK(Height > 0),
	Thickness integer  CHECK(Thickness > 0),
	Weight integer CHECK(Weight > 0), -- The weight is expressed in grams
	Stock integer CHECK(Stock > 0),
	TypeOfBook varchar(100) NOT NULL,
	FileSize integer CHECK(FileSize > 0), -- The file size is expressed in KB
	Ext"ension" varchar(255),
	Author_PB_ID integer,
	PublishingHouse_PB__ID integer,
	Category_PB_ID integer,
	constraint Author_PB_ID_FK FOREIGN KEY(Author_PB_ID) REFERENCES `dlivresdb`.Author(Author_ID),
	constraint PublishingHouse_PB_ID_FK  FOREIGN KEY(PublishingHouse_PB__ID) REFERENCES `dlivresdb`.PublishingHouse(PublishingHouse_ID),
	constraint Category_PB_ID_FK FOREIGN KEY(Category_PB_ID) REFERENCES `dlivresdb`.Category(Category_ID)
);

CREATE TABLE `dlivresdb`.OrderCustomer(
	OrderCustomer_ID integer auto_increment PRIMARY KEY,
	OrderCustomerDate DATE NOT NULL, -- format YYYY-MM-DD
	Customer_ID integer NOT NULL,
	constraint Customer_ID_FK foreign key(Customer_ID) references `dlivresdb`.Customer(Customer_ID)
);

CREATE TABLE `dlivresdb`.CommandLine(
	CommandLine_ID integer auto_increment PRIMARY KEY,
	Quantity integer NOT NULL,
	Book_ID integer,
	OrderCustomer_ID integer,
	constraint Book_ID_CL_FK FOREIGN KEY(Book_ID) REFERENCES Book(Isbn),
	constraint OrderCustomer_ID_FK foreign key(OrderCustomer_ID) references OrderCustomer(OrderCustomer_ID)
);

CREATE TABLE `dlivresdb`.LanguageTranslationTitleOfBook(
	LanguageTranslationTitleOfBook_ID integer auto_increment PRIMARY KEY,
	TranslationTitleOfBook varchar(255) NOT NULL,
	CurrentLanguage_ID varchar(2) NOT NULL,
	Book_ID integer NOT NULL,
	constraint CurrentLanguage_ID_FK foreign key(CurrentLanguage_ID) references `dlivresdb`.CurrentLanguage(CurrentLanguage_ID),
	constraint Book_ID_LT_FK foreign key(Book_ID) references `dlivresdb`.Book(Isbn)
	);

CREATE TABLE `dlivresdb`.LanguageTranslationWordingOfCategory(
	LanguageTranslationWordingOfCategory_ID integer auto_increment PRIMARY KEY,
	TranslationWordingOfCategory varchar(255) NOT NULL,
	CurrentLanguage_ID varchar(2) NOT NULL,
	Category_ID integer NOT NULL,
	constraint CurrentLanguage_ID_WC_FK foreign key(CurrentLanguage_ID) references `dlivresdb`.CurrentLanguage(CurrentLanguage_ID),
	constraint Category_ID_FK foreign key(Category_ID) references `dlivresdb`.Category(Category_ID)
	);
/*-----Insertion----*/
INSERT INTO `dlivresdb`.CurrentLanguage (currentLanguege_id,NameLanguage)
	VALUES
		("en","English"),
		("fr","Français");

		/*MDP CRYPTE DONC MIEUX VIA INSCRIPTION */

INSERT INTO `dlivresdb`.Customer (Email, Name, FirstName, PhoneNumber, BirthDate,
					Street, StreetNumber, PostalCode, City, Country, Password)
	VALUES
		("cyrilcolot@hotmail.com", "Colot", "Cyril", "0498778524", "19960115",
			"Rue du refuge", 6, 5500, "Dinant", "Belgique", "root");

INSERT INTO `dlivresdb`.Author(Name, FirstName)
	VALUES
	
		("George", "Martin"),
		("Ken", "Follett"),
		("Frank", "Herbert"),
        ("Isaac", "Asimov"),
        ("Jean Marie", "Auel"),
        ("J.R.R", "Tolkien");
		
	INSERT INTO `dlivresdb`.PublishingHouse(Wording)
	VALUES

		("Pocket"),
		("J'ai Lu"),
		("Folio"),
		("Le livre de Poche");
		
INSERT INTO `dlivresdb`.Category(Category_ID)
	VALUES
		-- Historique
		(1),
		-- Science-Fiction
		(2),
		-- Fanta
		(3);	

INSERT INTO `dlivresdb`.Book(Isbn, Price, Summary, NumberOfPages, PublicationDate, Height, Width, Thickness, Weight, Stock, TypeOfBook, FileSize, Extension, Author_PB_ID, PublishingHouse_PB_ID,Category_PB_ID)
	VALUES
    
        -- Dune
        
        (22210260, 9.99, "Il n'y a pas, dans tout l'Empire, de planète plus inhospitalière que Dune. Partout des sables à perte de vue. Une seule richesse : l'épice de longue vie, née du désert, et que tout l'univers convoite.",
        412,"19700322", 1500, 250,200,300,15,"Paper book",null,null,3,1,2);
        
        -- Les pilliers de la terre
        
		(23698413, 11.90, "Dans l'Angleterre du XIIe siècle ravagée par la guerre et la famine, des êtres luttent chacun à leur manière pour s'assurer le pouvoir, la gloire, la sainteté, l'amour, ou simplement de quoi survivre.",
        1056,"19920415", 1100, 400,650,400,5,"Paper book",null,null,2,4,1);
        
		-- Un monde sans fin 
        
        (23698536, 12.90, "1327. Quatre enfants sont les témoins d’une poursuite meurtrière dans les bois : un chevalier tue deux soldats au service de la reine, avant d’enfouir dans le sol une lettre mystérieuse, dont la teneur pourrait mettre en danger la couronne d’Angleterre. "
        ,1344,"20100106", 1100, 520,650,400,8,"Paper book",null,null,2,4,1);
        
		-- Une colonne de feu
		
        (23698963, 10.90, "Noël 1558, le jeune Ned Willard rentre à Kingsbridge. Il découvre une ville déchirée par la haine religieuse, et se retrouve dans le camp adverse de celle qu'il voulait épouser, Margery Fitzgerald. "
        ,992,"20100106", 1100, 370,650,400,12,"Paper book",null,null,2,4,1);
		
        -- Le clan des ours des cavernes
         
        (14563698, 9.99, "Quelque part en Europe, 35 000 ans avant notre ère. Petite fille Cro-Magnon de cinq ans, Ayla est séparée de ses parents à la suite d'un violent tremblement de terre. Elle est recueillie par le clan de l'ours des cavernes, une tribu Neandertal.",
        537,"20101109", null, null,null,null,null,"Ebook",2500,"epub",5,1,1);
        
        -- La Vallée des chevaux
        
        (14563860, 8.40, "Passé la surprise et l'émerveillement suscités par Ayla, la jeune étrangère aux cheveux blonds qu'ils ont recueillie, les hommes du 'clan de l'ours ' ont pris peur de ses dons extraordinaires.",
        700,"20190123", null, null,null,null,null,"Ebook",2500,"epub",5,1,1);
        
        -- Les chasseurs de mammouths
        
        (1693417, 8.40, "Pendant plusieurs saisons, Ayla et son compagnon Jondalar ont tout partagé. Ils ont taillé le silex, entretenu le feu, chassé le renne et le cerf, construit des abris et des bateaux.",
        928,"20160211", null, null,null,null,null,"Ebook",2500,"epub",5,1,1);
        
        -- Le grand voyage
    
        (16749463, 7.40, "Ayla et Jondalar poursuivent leur traversée des steppes immenses du continent européen. La femme aux cheveux d'or et le géant blond suscitent le trouble et l'effroi sur leur passage. ",
        992,"20020418", null, null,null,null,null,"Ebook",3500,"epub",5,1,1);
        
        -- Le pays des grottes sacrées
        
        (16747963, 7.90, "Un an après son arrivée dans la tribu néandertalienne de la Neuvième Caverne, Ayla, la jeune Cro-Magnon, continue son intégration dans la petite communauté. Ses talents de guérisseuse et sa connaissance des animaux impressionnent.",
        1084,"20120202", null, null,null,null,null,"Ebook",3800,"epub",5,1,1);
        
        -- Le Seigneur des anneaux 
        
        (23659846, 18.75, "Une contrée paisible où vivent les Hobbits. Un anneau magique à la puissance infinie. Sauron, son créateur, prêt à dévaster le monde entier pour récupérer son bien. Frodon, jeune Hobbit, détenteur de l'Anneau malgré lui.",
        1600,"20180913", 1290, 62,185,500,25,"Paper book",null ,null ,6,1,3);
        
        -- Le trone de fer intégrales 1
        
        (36987145, 22.00, "Le royaume des Sept Couronnes est sur le point de connaître son plus terrible hiver : par-delà le Mur qui garde sa frontière nord, une armée de ténèbres se lève, menaçant de tout détruire sur son passage.",
        800,"20190410", 1380, 44,200,500,3,"Paper book",null ,null ,1,2,3);
        
        
        -- le trone de fer intégrales 2 
        
        (36987245, 22.00, "Le royaume des Sept Couronnes est sur le point de connaître son plus terrible hiver : par-delà le Mur qui garde sa frontière nord, une armée de ténèbres se lève, menaçant de tout détruire sur son passage.",
        954,"20190925", 1380, 50,200,500,5,"Paper book",null ,null ,1,2,3)
        
        
        -- le trone de fer intégrales 3
        
        (36987321, 23.00, "Le royaume des Sept Couronnes est sur le point de connaître son plus terrible hiver : par-delà le Mur qui garde sa frontière nord, une armée de ténèbres se lève, menaçant de tout détruire sur son passage.",
        1152,"20191106", 1410, 55,200,500,1,"Paper book",null ,null ,1,2,3);
        
        -- le trone de fer intégrales 4
        
        (36987453, 23.00, "Le royaume des Sept Couronnes est sur le point de connaître son plus terrible hiver : par-delà le Mur qui garde sa frontière nord, une armée de ténèbres se lève, menaçant de tout détruire sur son passage.",
        896,"20191106", 1380, 50,200,500,4,"Paper book",null ,null ,1,2,3);
        
        -- le trone de fer intégrales 5
        
        (36987589, 24.00, "Le royaume des Sept Couronnes est sur le point de connaître son plus terrible hiver : par-delà le Mur qui garde sa frontière nord, une armée de ténèbres se lève, menaçant de tout détruire sur son passage.",
        1200,"20191106", 1390, 56,200,500,4,"Paper book",null ,null ,1,2,3);
        
      
        
        -- Fondation
        
        (89632214, 7.50, "En ce début de treizième millénaire, l'Empire n'a jamais été aussi puissant, aussi étendu à travers toute la galaxie. C'est dans sa capitale, Trantor, que l'éminent savant Hari Seldon invente la psychohistoire.",
        416,"20090326", 1800, 1000,100,250,10,"Paper book",null ,null ,4,3,2);
        
        -- Fondation et Empire
        
        (89634598, 8.00, "Tandis que les crises qui secouent l'Empire redoublent de violence et annoncent son effondrement définitif, la Fondation créée par le psychohistorien Hari Seldon pour sauvegarder la civilisation devient de plus en plus puissante.",
        432,"20090326", 1800, 1100,180,250,10,"Paper book",null ,null ,4,3,2);
        
        -- Seconde Fondation
        
        (96354210, 8.00, "Conçue par le psychohistorien Hari Seldon pour restreindre l'ère de chaos résultant de la décadence de l'Empire galactique, la Fondation est désormais aux mains du Mulet, un mutant imprévisible.",
        432,"20090326", 1800, 1000,180,250,10,"Paper book",null ,null ,4,3,2);
        
			

		
INSERT INTO `dlivresdb`.LanguageTranslationTitleOfBook(TranslationTitleOfBook, currentLanguage_id,book_id)
	VALUES
		("Foundation","en",89632214),
        ("Fondation","fr",89632214), 
        ("Foundation and Empire","en", 89634598),
        ("Fondation et Empire","fr", 89634598),
        ("Second Foundation","en", 96354210),
        ("Seconde Fondation","fr", 96354210),
        ("A Game of Thrones", "en", 36987145),
        ("A Game of Thrones", "fr", 36987145),
        ("A Clash of Kings","en",36987245),
        ("A Clash of Kings","fr",36987245),
        ("A Storm of Swords","en",36987321),
        ("A Storm of Swords","fr",36987321),
        ("A Feast for Crows","en",36987453),
		("A Feast for Crows","fr",36987453),
        ("A Dance with Dragons","en",36987589),
        ("A Dance with Dragons","fr",36987589),
        ("The Lord of the Rings","en", 23659846),
        ("Le Seigneur des Anneaux","fr", 23659846),
        ("The Clan of the Cave Bear","en", 14563698),
        ("Le Clan des Ours des Cavernes","fr", 14563698),
        ("The Valley of Horses","en", 14563860),
        ("La Vallée des Chevaux","fr",14563860), 
        ("The Mammoth Hunters","en", 1693417),
        ("Les Chasseurs de Mammouths","fr",1693417),
        ("The Plains of Passage","en",16749463),
        ("Le Grand Voyage","fr",16749463),
        ("The Land of Painted caves","en",16747963),
        ("Le Pays des Grottes Sacrées","fr",16747963), 
        ("The Pillars of the Earth","en",23698413),
        ("Les Pilliers de la Terre", "fr", 23698413),
        ("World Without End","en", 23698536),
        ("Un Monde Sans Fin","fr",23698536),
        ("A Column of Fire","en", 23698963), 
        ("Une Colonne de Feu","fr",23698963),
        ("Dune","en", 22210260),
        ("Dune","fr", 22210260);
        
INSERT INTO `dlivresdb`.LanguageTranslationWordingOfCategory(TranslationWordingOfCategory,CurrentLanguage_ID,Category_ID)
	VALUES
		
		("Fantastic", "en",3),
		("Fantastique","fr",3),
		
		 
		("Historical fiction","en",1),
		("Roman historique","fr",1),
		
		
		("Science-fiction","en",2),
		("Science-fiction","fr",2);