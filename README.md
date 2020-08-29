# Crazy-Monster-Truck

Vidéo de démonstration : https://www.youtube.com/watch?v=YV_hfIY4Qn0

Initialement nommé Monster Truck Challenge, CMT est un jeu imaginé par mon fils. Inspiré par Hill Climb Racing, ce jeu avait pour cahier des charges plusieurs caractéristiques :

-> Une boutique proposant différents choix de pilote, circuit et véhicule.

![alt text](https://github.com/DavidLiger/Crazy-Monster-Truck/blob/master/img/article-1-img-1.png)

-> Un atelier pour créer son propre véhicule.

![alt text](https://github.com/DavidLiger/Crazy-Monster-Truck/blob/master/img/article-1-img-2.png)

-> Un menu pour récapituler toutes les infos du joueur : points collectés, argent, trophées... 

![alt text](https://github.com/DavidLiger/Crazy-Monster-Truck/blob/master/img/article-1-img-3.png)

-> Une partie de jeu durant laquelle on doit écraser les voitures précédents le joueur.

![alt text](https://github.com/DavidLiger/Crazy-Monster-Truck/blob/master/img/article-1-img-4.png)

-> Le véhicule devra obligatoirement refaire le plein en carburant en récupérant des jerrycans d'essence.

-> Le joueur peut augmenter son score en attrapant des pièces d'or.

-> Des bonus sont placés sur le parcours aléatoirement. L'un deux "la nitro" permet d'exploser les ennemis sans avoir à sauter pour toucher la tête du pilote.

-> Implémenter le système de publicité vidéo du programme Google Admob.

Après quatre mois de développement et un mois de travail graphique, le jeu est enfin publié sur le Google Playstore.

Le résultat est certes loin de la qualité d'un triple A mais il m'a permis d'apprendre énormément. J'ai, en effet développé durant ce projet , un programme constitué de toutes les fonctionnalités de base de tout jeu : choix des personnages, modification de ce personnage, système d'achat, instanciation aléatoire d'ennemi, gestion des collisions, cycle de vie de jeu ( du menu au "game over" ), système commercial...etc...

N'hésitez pas à le tester en l' installant depuis le Playstore :

https://play.google.com/store/apps/details?id=com.dumbocracy.crazymonstertruck&hl=en_US

- Framework : LibGDX :

Créé et maintenu par Mario Zechner depuis 2009, "LibGDX est un framework de développement de jeux multi-plateformes de niveau relativement bas, gratuit et open-source" (site officiel).

L'objectif du framework est d'aider à créer des jeux ou applications et de les déployer sur des plateformes mobiles et de bureau en laissant libre cours à tout type de conception.

LibGDX est libre, sous licence Apache 2 open source, permettant à tout un chacun de l'utiliser.

Doté de nombreux outils de haut-niveau permettant de démarrer un projet rapidement, le framework autorise, en outre, un accès complet à l'API de bas-niveau, si besoin.


- Explication détaillée de la fonctionnalité d’instanciation aléatoire de véhicules ennemis

Installer le jeu
Code-source


Principe : Le but du jeu Crazy Monster Truck étant d’écraser les véhicules devançant celui du joueur, le programme devra instancier de nouveaux véhicules au fur et à mesure de la progression du joueur.

I-Le Déclencheur :

![alt text](https://github.com/DavidLiger/Crazy-Monster-Truck/blob/master/img/article-10-img-1.png)

Le véhicule du joueur sera le déclencheur de l’apparition des véhicules. J’ai utiliser TILED pour modéliser une map 2D (une suite de colline) qui constitue le terrain sur lequel roule les véhicules.

TILED permet de créer différents calques, j’ai utilisé un calque pour simplement enregistré des positions equidistantes. Lorsque le véhicule du joueur approche à une certaine distance de chacune de ces positions (juste avant que cette position entre dans le «champ de la caméra »), un véhicule est ajouté à la partie.

Ainsi ce système donne l’illusion que l’on rattrape toujours de nouveaux véhicules, sans pour autant en ajouter un grand nombre au démarrage de la partie et ainsi engendrer une charge inutile pour l’appareil.

II-Le modèle : un véhicule-type


![alt text](https://github.com/DavidLiger/Crazy-Monster-Truck/blob/master/img/article-10-img-2.png)

Comme on peut le voir sur le schéma précédent, un véhicule est constituer de différents éléments de l’API Box2D, des bodies et des joints. En appliquant une certaine rotation à une roue, l’ensemble des bodies et joints reliés entre eux avancent. La tête est reliée à un RevoluteJoint, un type de jointure qui laisse libre le body auquel il est rattaché, autorisant un mouvement de hochet propre à certains jouets ou gadgets.

III-Le code :

![alt text](https://github.com/DavidLiger/Crazy-Monster-Truck/blob/master/img/article-10-img-3.png)

Le diagramme de classe représente l’ensemble du projet. J’évoquerai uniquement les classes surlignées dans l’explication de cette fonctionnalité.

Controleur : MTCGame :
Au démarrage du jeu, dans la classe MTCGame, la méthode create() qui surcharge la méthode héritée de Game(la classe native de LibGDX qui permet de créer un jeu) appelle la méthode SetScreen().

SetScreen() est la méthode qui lance un nouvel écran à chaque appel. Ainsi le LifeCycle du jeu est géréÒ par cette méthode qui appelle chaque « Screen » au moment de passer à la phase suivante du jeu (MenuScreen, GameScreen, GameOverScreen…)

![alt text](https://github.com/DavidLiger/Crazy-Monster-Truck/blob/master/img/article-10-img-4.png)

ex : Lorsque les éléments de MenuScreen sont chargés, le SplashPreLoadingScreen nous y envoie.

![alt text](https://github.com/DavidLiger/Crazy-Monster-Truck/blob/master/img/article-10-img-5.png)

ex : Lorsque nos choix de personnages, circuit et véhicules sont fait le bouton play nous envoie vers le GameScreen.


1-Rafraichissement d’image :
Gamescreen.java


    public class GameScreen extends ScreenAdapter {
        @Override
        public void render(float delta) {
                  [...]
                update();
                  [...]
        }
                

LibGDX propose une classe-mère, ScreenAdapter, qui gère, via la méthode render(), le renouvellement de l’image affichée à une fréquence de 60Hz par défaut. On placera donc dans cette méthode tous les appels de méthode nécessitant un rafraîchissement continu.

Par commodité, une partie de ces méthodes sont rassemblés dans update().

Gamescreen.java


    private void update() {
                          [...]
                    // update des méthodes de vehicules ennemis
                    createEnemiesVehicules();							
							                

La méthode qui nous intéresse est createEnemiesVehicule().

2-Conditions d’instanciation :
Gamescreen.java


    private void createEnemiesVehicules() {
            enemiesPositions = ground.getEnemiesPositions();
            if (EnemiesVehicules.size < 4) {
                for (Vector2 position : enemiesPositions) {
                    if (position.x < vehicule.getChassis().getPosition().x + viewport.getWorldWidth()) {
                        if (isPlaceFree()) {
                            VehiculeGenerator EnemyVehicule = new VehiculeGenerator(createVehiculeDef(99,""),
                                    mtcGame,world,pilote,position,99);
                            enemiesPositions.removeIndex(0);
                            EnemiesVehicules.add(EnemyVehicule);
                            nbEnemies += 1;
                        }
                    }
                }
            }
        }		
		                

On a d’abord besoin des coordonnées de chaque point d’apparition des véhicules. Pour cela on récupère, dans une liste des carrés du calque enemiesPositions.

3-Le décor :
Gamescreen.java


    public GameScreen(MTCGame mtcGame, SpriteBatch batch, Array
			 vehiculeCustomAssetsToUnload) {
              [...]
        groundChoice = mtcGame.getPrefs().getInteger("groundChoice");
              [...]
        ground = new GroundGenerator(createDecorDef(),mtcGame, world, batch, box2dCam);
    }
                

C’est la méthode getEnemiesPositions() de ground, l’objet de «type » GroundGenerator qui nous permettra de récupérer cette liste de position. On instancie le ground dans le constructeur de GameScreen.

La variable « groundChoice » est utilisée par la méthode createDecorDef() une méthode qui permet de choisir les infos nécessaires à l’instanciation du décor selon les choix enregistrés au Screen précédent (MenuScreen).

4-Les positions des ennemis :
GroundGenerator.java


    public GroundGenerator(DecorDef decorDef, MTCGame mtcGame, World world, SpriteBatch batch, Camera camera){
              [...]
        // ennemis véhicules : récupération des positions
        MapObjects groundMapObjectsEnemies = tiledMap.getLayers().get("positionsEnemies").getObjects();
        for (MapObject object : groundMapObjectsEnemies) {
            RectangleMapObject rectangleMapObject = (RectangleMapObject) object;
            enemiesPositions.add(rectangleMapObject.getRectangle().getPosition(new Vector2()));
        }
                

Le GroundGenerator utilise, pour remplir sa liste de positions, EnemiesPositions, une classe native de LibGDX, le MapObjects qui autorise l’enregistrement de différentes données d’un « objet » graphique. Ici, les mapObjects sont converti en RectangleMapObject et on en extraie les positions stockées dans dans Vector2 (coordonnées en X et en Y) stockés dans la liste EnemiesPositions renvoyés vers le GameScreen.

5-Apparition à bonne distance :

![alt text](https://github.com/DavidLiger/Crazy-Monster-Truck/blob/master/img/article-10-img-6.png)
Gamescreen.java


    private boolean isPlaceFree() {
        if (EnemiesVehicules.size > 0) {
            for (VehiculeGenerator vehiculeGenerator : EnemiesVehicules) {
                if (enemiesPositions.size > 1) {
                    if (enemiesPositions.get(0).x - vehiculeGenerator.getChassis().getPosition().x < 50) {
                        freePlace = false;
                        freeTime = 0;
                        if (enemiesPositions.size > 0) {
                            enemiesPositions.removeIndex(0);
                        }
                    }
                }
            }
        }
        return freePlace;
    }
                

Une fois notre liste de position remplie, on peut instancié nos véhicules, sous condition qu’il y en est moins de quatre déjà en jeu.

Ainsi pour chacune des positions, si la position en x est inférieure à celle du châssis (body central) du véhicule du joueur ajouté à la largeur du viewport (de la scène) qui, ici, correspond à la moitié de l’écran. Autrement dit, lorsque la position d’apparition du véhicule pénètre dans la scène, alors on fait apparaître un véhicule ennemi...si la place est libre.

6-Faites place :
Gamescreen.java


    private void freePlaceTimer() {
        if (!freePlace) {
            if (freeTime < 5) {
                freeTime += 0.1f;
            }
        }
        if (freeTime >= 5) {
            freePlace = true;
            freeTime = 0;
        }
    }
                

Pour éviter d’avoir des collisions inopinées (et des apparitions hasardeuses de véhicules dans le ciel, chutant sur les voitures déjà présentes), on ne fait apparaître les ennemis que lorsque la place est libre.

Ainsi, sous condition que la liste des véhicules ennemis ne soit pas vide (qu’il y est des ennemis présents sinon la place est forcément libre !), on boucle sur la liste des positions (à condition qu’elle ne soit pas nulle, donc supérieure à 1) et si la position première de la liste(à l’indice 0) est à moins de 50 pixels de la position d’un véhicule, alors elle retournera faux.

Elle empêchera l’apparition désordonnée d’un véhicule puis positionne la variable freeTime à 0 (voir paragraphe suivant), et sous condition qu’il y ait d’autres positions dans la liste, supprime l’indice 0 afin de faire monter en première indice (0), la position suivante et ainsi, de nouveau, contrôler si la place est libre.

7-Effet ressort :
VehiculeGenerator.java


    public VehiculeGenerator(VehiculeDef vehiculeDef,MTCGame mtcGame, World world, PiloteGenerator pilote, Vector2 carPosition, int headChoice) {
        this.world = world;
        this.pilote = pilote;
        this.headChoice = headChoice;
        this.carPosition = carPosition;
        this.vehiculeDef = vehiculeDef;
            [...]
    }
                

La place étant normalement libre isPlaceFree() contrôle une éventuelle collision puis prévoit le contrôle sur la position suivante que les véhicules n’ont pas encore atteint et, où la place est donc normalement libre. Un timer de 5 secondes est donc suffisant pour rebasculer à true, la variable freePlace et, de nouveau, l’utiliser dans la méthode isPaceFree().

8-Génération d’autos :
Gamescreen.java


    private void createEnemiesVehicules() {
            [...]
        VehiculeGenerator EnemyVehicule = new VehiculeGenerator(createVehiculeDef(99,""),
                                mtcGame,world,pilote,position,99);
    }
                

Le constructeur de véhicule aura besoin d e six paramètres pour créer un véhicule :

  Le world qui est créé dans le GameScreen est un singleton et est donc passé en paramètre aux autres Screen. En effet, c’est un objet relativement lourd car il définit le monde physique dans lequel évolue tous les objets 2D.
    Le pilote est un objet qui comporte une méthode générant des têtes d’animaux au hasard.
    carPosition, de type Vector2, est la position où apparaitra le véhicule comme vu précédemment.
    la variable headchoice, qui interviendra dans le choix de la tête.
    La VéhiculeDef, l’ADN du véhicule !

9-Le choix du hasard :
Gamescreen.java


    private VehiculeDef createVehiculeDef(int vehiculeChoice, String player){
        if(vehiculeChoice != 99){
            if(vehiculeChoice == 0){
                vehiculeDef = new VehiculeSansPermis(mtcGame,player);
            }
            if(vehiculeChoice == 1){
                [...]
        }else{
            vehiculeChoice = MathUtils.random(0,11);
            createVehiculeDef(vehiculeChoice,player);
        }
        return vehiculeDef;
    }
                

Afin de varier les différents véhicules à écraser on utilise une méthode qui va instancier une VéhiculeDef (définition de véhicule) qui regroupe tous les paramètres (de taille de roue, de forme du chassis, sprite -image associée à chaque partie du véhicule- voir code sur GitHub).

Soit le paramètre VéhiculeChoice est connu (choix du joueur) et on retourne le véhicule choisi, soit, dans le cas des véhicules ennemis, on envoie 99 qui est un déclencheur de Random de MathUtils. Il restera à passer dans cette même méthode mais cette fois-ci avec un vrai choix de véhicule.

10-Construction : le procédé :
VehiculeGenerator.java


    public VehiculeGenerator(VehiculeDef vehiculeDef,MTCGame mtcGame, World world, PiloteGenerator pilote, Vector2 carPosition, int headChoice) {
            [...]
        createBodiesAndJoints();
    }
                

Nos paramètres étant tous réunis on peut, désormais appeler la méthode qui va créé le véhicule : createBodiesAndJoints().

Cette méthode utilise des outils et des concepts de Box2D qu’il convient de suivre rigoureusement si l’on veut obtenir un pantin ou ensemble d’objets réagissant de façon réaliste à une simulation de monde physique (gravité, rebonds, collision).

A-Les Fixtures : des modèles de Fabrication :
VehiculeGenerator.java


    private void createBodiesAndJoints(){
        // shapes
        PolygonShape chassisShape = new PolygonShape();
        chassisShape.set(vehiculeDef.getChassisShapeFloatArray());

        CircleShape leftWheelShape = new CircleShape();
        leftWheelShape.setRadius(vehiculeDef.getWheelRadius());

        CircleShape rightWheelShape = new CircleShape();
        rightWheelShape.setRadius(vehiculeDef.getWheelRadius());

        // réglages fixture
        FixtureDef chassisFixtureDef = new FixtureDef();
        chassisFixtureDef.density = vehiculeDef.getChassisFixtureDefDensity();
        chassisFixtureDef.shape = chassisShape;

        // réglages fixture roue gauche
        FixtureDef leftWheelFixtureDef = new FixtureDef();
        leftWheelFixtureDef.density = vehiculeDef.getChassisFixtureDefDensity() * 2;
        leftWheelFixtureDef.friction = vehiculeDef.getWheelFixtureDefFriction();
        leftWheelFixtureDef.restitution = vehiculeDef.getWheelFixtureDefRestitution();
        leftWheelFixtureDef.shape = leftWheelShape;

        // réglages fixture roue droite
        FixtureDef rightWheelFixtureDef = new FixtureDef();
        rightWheelFixtureDef.density = vehiculeDef.getChassisFixtureDefDensity() * 8;
        rightWheelFixtureDef.friction = vehiculeDef.getWheelFixtureDefFriction();
        rightWheelFixtureDef.restitution = vehiculeDef.getWheelFixtureDefRestitution();
        rightWheelFixtureDef.shape = rightWheelShape;

        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
            [...]
    }
                

Comme un patron en couture, ou un plan en usinage, la réalisation d’une pièce demande souvent à ce que soit défini des mesures.

Deux choses sont nécessaires à Box2D avant de créer les parties du véhicule : les formes (shape) et des dispositifs (fixtures), objets qui regroupent les informations de densité, friction, restitution. Ce sont les «fixturedef » qui utilisent les « shape » comme paramètre.

Une fois paramétré chaque « fixture » représente le modèle sur lequel sera créée une partie du véhicule. Notons que les infos de paramétrage sont regroupés dans les VéhiculeDef. Enfin le BodyDef sert à définir la nature des bodies que l’on créera ensuite : Dynamic pour un personnage, Static pour un élément de décor, Kinematic pour un élément automatisé (plateforme faisnt un aller-retour en boucle).

B-Les bodies : pièces principales :
VehiculeGenerator.java


    private void createBodiesAndJoints(){
            [...]
        // chassis

        chassis = world.createBody(def);
        chassisFixture = chassis.createFixture(chassisFixtureDef);
        chassis.setTransform(new Vector2(carPosition.x, carPosition.y), 0);
        chassis.setUserData("chassis");

        // left wheel
        leftWheel = world.createBody(def);
        leftWheelFixture = leftWheel.createFixture(leftWheelFixtureDef);
        leftWheel.setUserData("leftWheel");

        // right wheel
        rightWheel = world.createBody(def);
        rightWheelFixture = rightWheel.createFixture(rightWheelFixtureDef);
        rightWheel.setUserData("rightWheel");

        bodies.add(chassis);
        bodies.add(rightWheel);
        bodies.add(leftWheel);

        // dead box
        CircleShape deadBoxShape = new CircleShape();
        deadBoxShape.setRadius(vehiculeDef.getDeadBoxShapeRadius());

        FixtureDef deadBoxdef = new FixtureDef();
        deadBoxdef.density = vehiculeDef.getChassisFixtureDefDensity() / 10;
        deadBoxdef.shape = deadBoxShape;

        deadBox = world.createBody(def);
        deadBoxFixture = deadBox.createFixture(deadBoxdef);
        deadBox.setUserData("deadBox");
        bodies.add(deadBox);

        RevoluteJointDef axisJointDef = new RevoluteJointDef();
        axisJointDef.bodyA = chassis;
        axisJointDef.bodyB = deadBox;
        // réglage position du cou
        axisJointDef.localAnchorA.set(vehiculeDef.getNeckLocalAnchorAPosition().x,vehiculeDef.getNeckLocalAnchorAPosition().y);
        axisJointDef.localAnchorB.set(vehiculeDef.getNeckLocalAnchorBPosition().x,vehiculeDef.getNeckLocalAnchorBPosition().y);
        axisJointDef.enableLimit = true;
        axisJointDef.upperAngle = 10 * MathUtils.degreesToRadians;
        axisJointDef.lowerAngle = -10 * MathUtils.degreesToRadians;
        axisJointDef.referenceAngle = 0;
//        axisJointDef.frequencyHz = wheelJointDefFrequencyHz / 2;
        RevoluteJoint deadBoxAxis = (RevoluteJoint) world.createJoint(axisJointDef);
        deadBoxAxis.setUserData("deadBoxAxis");
        joints.add(deadBoxAxis);
            [...]

        

    }
                

Comme les paramètres de forme et de physique sont rassemblés, on créé le corps qui a son tour créé le fixture (sur le modèle du fixtureDef) afin de conservé ses paramètres séparément.

Ainsi un corps peut avoir plusieurs fixtures influants sur sa masse et sa gravité. Lorsque deux corps entrent en contact (ex : la roue et le sol), leurs fixtures sont utilisés pour interpréter leur comportement. Dans le cas du chassis, on ajoute la position puis on créé une donnée utilisateur (.setUserData()) afin de nommer le body avec une String que l’on utilisera pour associé une image.

On ajoute ces bodies à une liste afin de sérialiser leur traitement par la suite. On retrouve enfin tout c e processus pour la création de la tête du pilote.

C-Les joints : relier le tout :
VehiculeGenerator.java


    private void createBodiesAndJoints(){
            [...]
        // left axis
        WheelJointDef axisDef = new WheelJointDef();
        axisDef.bodyA = chassis;
        axisDef.bodyB = leftWheel;
        axisDef.localAnchorA.set(vehiculeDef.getWheelLocalAnchorAPosition().x, vehiculeDef.getWheelLocalAnchorAPosition().y - leftWheelShape.getRadius()/3);
        axisDef.localAxisA.set(Vector2.Y);
        axisDef.frequencyHz = vehiculeDef.getAxisDefFrequencyHz();

        leftAxis = (WheelJoint) world.createJoint(axisDef);

        // positions relatives des bodies
        leftWheel.setTransform(new Vector2(carPosition.x + axisDef.localAnchorA.x,
                carPosition.y + axisDef.localAnchorA.y), 0);
        rightWheel.setTransform(new Vector2(carPosition.x - axisDef.localAnchorA.x,
                carPosition.y + axisDef.localAnchorA.y), 0);
        deadBox.setTransform(new Vector2(carPosition.x, carPosition.y + 20), 0);

        // right axis
        axisDef.bodyB = rightWheel;
        axisDef.localAnchorA.x *= -1;
        rightAxis = (WheelJoint) world.createJoint(axisDef);

        leftWheelShape.dispose();
        rightWheelShape.dispose();
        chassisShape.dispose();
            [...]
                

Les jointures (joints) servent comme leur nom l’indiquent, à relier les bodies. Comme pour les bodies, elles ont besoin d’un « plan » pour définir leur forme, leurs caractéristiques et leur comportement.

Ici, on s’épargnera l’étape des Fixtures, puisque le JointDef définit à la fois le type de Joint et ses caractéristiques.

On choisit ici un RevoluteJoint qui permet à l’objet auquel il est relié de tourner sur lui-même.

On lui indique entre quels bodies il sera tracé puis les LocalAnchorA et B servent à préciser les positions d’ancrage du joint. On lui assigne une limite de mouvement définie par un angle haut (dans un sens) et bas (dans l’autre). Ici on ne parle pas de degré mais de radian, une autre façon de mesurer les angles. Enfin on prend pour référence une position droite soit 0 degré.

Le joint étant défini c’est le world lui-même qui le créé. Afin de le gérer plus facilement, on l’ajoute à une liste après l’avoir nommé.

On applique le même processus pour les roues à ceci près qu’elles sont de type WheelJoint, ce qui ajoute des méthodes qu’on utilisera pour les faire tourner. On les place selon des positions définies dans la véhiculeDef. Afin de libérer de la mémoire on peut supprimer (dispose()) les shapes utilisées précédemment.

D-Habillage : les Sprites :
VehiculeGenerator.java


    private void createBodiesAndJoints(){
            [...]
        // sprites associées aux bodies
        for (Body body : bodies) {
            Sprite sprite = createSpritesForBodies(body);
            if (sprite != null) sprites.put(body, sprite);
        }

        // sprites "crashées" associées aux bodies
        for (Body body : bodies) {
            Sprite sprite = createCrashedSpritesForBodies(body);
            if (sprite != null) crashSprites.put(body, sprite);
        }

        // sprites "victorieux" associées aux bodies
        for (Body body : bodies) {
            Sprite sprite = createVictoriouspritesForBodies(body);
            if (sprite != null) victoriousSprites.put(body, sprite);
        }
                

Maintenant que notre véhicule est construit on doit lui « collé » les images qui représentent la carosserie, les roues et la tête du pilote afin d’avoir un joli résultat.

C’est là que nos listes interviennent. On boucle sur des listes d’objet afin de créer des ensemble de sprites associés aux bodies et stockés dans une arrayList de « type » ObjectMap qui, comme toute map, associe une clé à une valeur, mais ici avec das objets (voir code-source).

On utilise à chaque fois une méthode dédiée pour créer les sprites.

VehiculeGenerator.java


    private Sprite createSpritesForBodies(Body body) {
                  if ("deadBox".equals(body.getUserData())) {
                      return pilote.getHeadSprite(headChoice);
                  }
                  if ("chassis".equals(body.getUserData())) {
                      chassisSprite = createSprite(vehiculeDef.getChassisTexture());
                      return chassisSprite;
                  }
                  if ("leftWheel".equals(body.getUserData())) {
                      return createSprite(vehiculeDef.getWheelTexture());
                  }
                  if ("rightWheel".equals(body.getUserData())) {
                      return createSprite(vehiculeDef.getWheelTexture());
                  }
                  return null;
              }
					                

C’est ici qu’on retrouve notre userData qui permet d’associer les sprites aux bons éléments. Prenons par exemple, le sprite de la tête du pilote.On utilise la méthode getHeadSprite() de l’objet pilote.
PiloteGenerator.java


public Sprite getHeadSprite(int headChoice) {
                  return createHeadSprite(headChoice);
              }
					                

La méthode getHeadSprite() retourne le résultat de la fonction createHeadSprite()… <
PiloteGenerator.java


    private Sprite createHeadSprite(int headChoice) {
                  if (headChoice != 99) {
                      if (headChoice == 0) {
                          headSprite = new Sprite(textureAtlas.findRegion("requinHead"));
                      }
                      if (headChoice == 1) {
                          headSprite = new Sprite(textureAtlas.findRegion("wolfHead"));
                      }
                      if (headChoice == 2) {
                          [...]
                      }
          
                  } else {
                      randomHead = MathUtils.random(0, 59);
                      headSprite = HeadSpriteRandomGenerator.generateRandomizeHead(mtcGame,randomHead);
                  }
                  headSprite.setScale(0.25f, 0.25f);
                  headSprite.setOrigin(headSprite.getWidth() / 2, headSprite.getHeight() / 2);
                  return headSprite;
              }
					                

...qui comme la méthode createVehiculeDef() utilise Random de MathUtils lorsqu’elle reçoit 99 afin de choisir parmi 60 possibilités une tête d’animal.
PiloteGenerator.java


    public class HeadSpriteRandomGenerator {
          
              private static Sprite headSprite;
              private static Sprite headCrashedSprite;
          
              public static Sprite generateRandomizeHead(MTCGame mtcGame,int choix){
                  TextureAtlas textureAtlas = mtcGame.getAssetManager().get("preLoading_Total.atlas",TextureAtlas.class);
          
                  if(choix == 0){ headSprite = new Sprite(textureAtlas.findRegion("requinHead")); }
                  if(choix == 1){ headSprite = new Sprite(textureAtlas.findRegion("wolfHead")); }
                  if(choix == 2){ headSprite = new Sprite(textureAtlas.findRegion("T-RexHead")); }
                  if(choix == 3){ headSprite = new Sprite(textureAtlas.findRegion("horseHead")); }
                  if(choix == 4){ headSprite = new Sprite(textureAtlas.findRegion("rhinoHead")); }
                        [...]
					                

Dans la méthode statique de la classe HeadSpriteRandomGenerator(), on utilise le textureAtlas et sa méthode findRegion() pour, via l’AssetManager (un singleton transféré de classe en classe depuis la classe d’initialisation : MTCGame), afin de récupérer la partie d’image qui nous intéresse. En effet par souci d’économie de mémoire (vive et de stockage) on utilise les Atlas qui sont des regroupements de textures au sein d’une image.
Gamescreen.java

					               
    private void drawHead(SpriteBatch batch) {
                 // dessins sur bodies
                 for (Body body : sprites.keys()) {
                     if(body.getUserData().equals("deadBox")){
                         Sprite sprite = sprites.get(body);
                         sprite.draw(batch);
                     }
                 }
             }
					               
					             

La méthode drawHead qui est appelé par render(), et donc rafarichit à une fréquence de 60 Hz boucle sur les clés de la liste « sprites » pour récupérer à chaque clé, sa valeur : le sprite. Reste simplement à la dessiner, l’afficher via l’objet de « type » spriteBatch, une classe native de LibGDX chargé d’afficher les images. Cette classe instanciant un objet lourd, on l’utilise également en singleton.

IV-La boucle est bouclée : conclusion :
Gamescreen.java

				                
    private void createEnemiesVehicules() {
                enemiesPositions = ground.getEnemiesPositions();
                if (EnemiesVehicules.size < 4) {
                    for (Vector2 position : enemiesPositions) {
                        if (position.x < vehicule.getChassis().getPosition().x + viewport.getWorldWidth()) {
                            if (isPlaceFree()) {
                                VehiculeGenerator EnemyVehicule = new VehiculeGenerator(createVehiculeDef(99,""),
                                        mtcGame,world,pilote,position,99);
                                enemiesPositions.removeIndex(0);
                                EnemiesVehicules.add(EnemyVehicule);
                                nbEnemies += 1;
                            }
                        }
                    }
                }
            }
				                
				              

Après avoir contrôlé qu’il n’y avait pas plus de trois véhicules en jeu, qu’une position d’apparition était à bonne distance, vérifié que la place était libre, et produit un véhicule, il nous reste trois choses à faire.

-Premièrement, supprimer la position à l’indice 0 dans la liste. C’est celle qu’on vient de passer. Elle ne nous servira plus, on ne veut pas que des véhicules arrivent derrière nous et cela passera la position suivante à l’indice 0 automatiquement ce qui est indispensable pour reprendre tout le processus de création du prochain véhicule.

-Deuxiémement, ajouter le véhicule à la liste « EnemiesVehicles » afin de sérialiser son traitement.

-Troisièmement, incrémenter la variable nbEnemies qui représente le nombre total de véhicules mis en jeu. Cette donnée est utilisée pour calculer le taux de réussite du joueur dans la GameOverScreen.

Voilà, les véhicules sont sur la route, alors écrasons-les ! 
