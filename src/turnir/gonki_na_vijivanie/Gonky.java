//package turnir.gonki_na_vijivanie;
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.*;
//
//enum Zvery{
//    BEGUN("Бегун"),
//    PLOVCY("Пловцы"),
//    SCALOLASY("Скалолазы"),
//    SILACHY("Силачи"),
//    BOICY("Бойцы");
//    private final String imya;
//
//    public String getImya() {
//        return imya;
//    }
//
//    Zvery(String imya) {
//        this.imya = imya;
//    }
//}
//
//enum Style{OBEZIAN,TIGR,KRAKODIL,KAZEROG,SLON}
//
//enum Gruppa{
//    OBEZIANY("Команда обезьян"),
//    TIGRY("Команда тигров"),
//    KRAKODILY("Команда крокодилов"),
//    KOZEROGY("Команда козерогов"),
//    SLONY("Команда слонов");
//    private final String imya;
//
//    public String getImya() {
//        return imya;
//    }
//
//    Gruppa(String imya) {
//        this.imya = imya;
//    }
//}
//
//enum PrepyatstvieType{BEG,SCALOLASANIE,PLAVANIE,BOY,TYAJESTY}
//
//record StatisticPreodPrepyat(
//        double begScorosty,double begPoteryVinoslivosty,
//        double scalScorosty,double scalPoteryVinoslivosty,
//        double plavScorosty,double plavPoteryVinoslivosty,
//        double boyScorosty,double boyPoteryVinoslivosty,
//        double tyajScorosty,double tyajPoteryVinoslivosty
//){}
//
//record Predmety(String imya,double scorostyBonus,boolean isBonus){}
//
//class Soperniky {
//    private final Gruppa komanda;
//    private final Zvery zvery;
//    private final String imya;
//    private final Style style;
//
//    private double nachVinoslivosty;
//    private double potery = 0.0;
//    private double sluchayniyBonus = 0.0;
//    private Predmety activePredmety=null;
//
//    public Soperniky(Gruppa komanda, Zvery zvery,Style style, String imya) {
//        this.komanda = komanda;
//        this.zvery = zvery;
//        this.style=style;
//        this.imya = imya;
//
//        vostanovityVinoslivosty();
//    }
//
//    public void vostanovityVinoslivosty(){
//        nachVinoslivosty=1.0;
//        potery=0.0;
//        sluchayniyBonus=0.0;
//        activePredmety=null;
//    }
//
//    public double getBaseScorosty(PrepyatstvieType type){
//        StatisticPreodPrepyat s =SopernikyKachestva.get(zvery,style);
//        return switch (type){
//            case BEG->s.begScorosty();
//            case SCALOLASANIE -> s.scalScorosty();
//            case PLAVANIE -> s.plavScorosty();
//            case BOY -> s.boyScorosty();
//            case TYAJESTY -> s.tyajScorosty();
//        };
//    }
//
//    public double calculatorKonechVinoslivosty(double distance,PrepyatstvieType type){
//        double poteryVinosMetr=getVinoslPoteryMetr(type);
//        double konechVinoslivosty=1-(poteryVinosMetr*distance);
//        return Math.max(0.0,konechVinoslivosty);
//    }
//
//    private double getVinoslPoteryMetr(PrepyatstvieType type){
//        StatisticPreodPrepyat s=SopernikyKachestva.get(zvery,style);
//        return switch (type){
//            case BEG -> s.begPoteryVinoslivosty();
//            case SCALOLASANIE -> s.scalPoteryVinoslivosty();
//            case PLAVANIE -> s.plavPoteryVinoslivosty();
//            case BOY -> s.boyPoteryVinoslivosty();
//            case TYAJESTY -> s.tyajPoteryVinoslivosty();
//        };
//    }
//
//    public double calculateSredScorosty(double distance,PrepyatstvieType type){
//        double nachScorosty=getBaseScorosty(type);
//        double konechVinoslivosty=calculatorKonechVinoslivosty(distance, type);
//        double konechScorosty=konechVinoslivosty*nachScorosty;
//        double sredScorosty=(nachScorosty+konechScorosty)/2.0;
//
//        sredScorosty+=sluchayniyBonus;
//
//        if(activePredmety!=null){
//            sredScorosty+=activePredmety.scorostyBonus();
//        }
//
//        sredScorosty-=potery;
//
//        return Math.max(0.1,sredScorosty);
//    }
//
//    public double sluchSobitie(double distance,PrepyatstvieType type){
//        vostanovityVinoslivosty();
//
//        sluchayniyBonus=(Math.random()-0.5)*2.0*0.3;
//
//        double vremya=distance/calculateSredScorosty(distance, type);
//        return vremya;
//    }
//
//    public Gruppa getKomanda(){return komanda;}
//    public Zvery getZvery(){return zvery;}
//    public String getImya(){return imya;}
//
//    public void setPredmety(Predmety predmet){activePredmety=predmet;}
//    public Predmety getPredmety(){return activePredmety;}
//
//    public double getSluchayniyBonus(){return sluchayniyBonus;}
//}
//
//class Komanda{
//    private final Gruppa gruppa;
//    private final List<Soperniky> pamyaty=new ArrayList<>();
//
//    Komanda(Gruppa gruppa){this.gruppa=gruppa;}
//    public void addPamyaty(Soperniky a){pamyaty.add(a);}
//    public List<Soperniky> getPamyaty(){return pamyaty;}
//    public Gruppa getGruppa(){return gruppa;}
//}
//class SopernikyKachestva{
//    private static final Map<Map.Entry<Zvery, Style>, StatisticPreodPrepyat> STATS = Map.ofEntries(
//            // Бегуны: обезьяны быстрые, слоны медленные
//            Map.entry(Map.entry(Zvery.BEGUN, Style.OBEZIAN),  new StatisticPreodPrepyat(14.0, 0.00004, 1.0, 0.00010, 0.5, 0.00013, 0.01, 0.03, 0.01, 0.03)),
//            Map.entry(Map.entry(Zvery.BEGUN, Style.TIGR),     new StatisticPreodPrepyat(13.0, 0.00005, 1.0, 0.00010, 0.5, 0.00013, 0.01, 0.03, 0.01, 0.03)),
//            Map.entry(Map.entry(Zvery.BEGUN, Style.KRAKODIL), new StatisticPreodPrepyat(12.0, 0.00006, 1.0, 0.00011, 0.5, 0.00014, 0.01, 0.03, 0.01, 0.03)),
//            Map.entry(Map.entry(Zvery.BEGUN, Style.KAZEROG),  new StatisticPreodPrepyat(11.5, 0.00007, 1.0, 0.00012, 0.5, 0.00015, 0.01, 0.03, 0.01, 0.03)),
//            Map.entry(Map.entry(Zvery.BEGUN, Style.SLON),     new StatisticPreodPrepyat(9.0,  0.00008, 1.0, 0.00013, 0.5, 0.00016, 0.01, 0.03, 0.01, 0.03)),
//
//            // Скалолазы: крокодилы и обезьяны лучше лазают
//            Map.entry(Map.entry(Zvery.SCALOLASY, Style.OBEZIAN),  new StatisticPreodPrepyat(10.0, 0.00005, 2.5, 0.00007, 0.5, 0.00013, 0.01, 0.03, 0.01, 0.03)),
//            Map.entry(Map.entry(Zvery.SCALOLASY, Style.TIGR),     new StatisticPreodPrepyat(10.0, 0.00005, 2.3, 0.00008, 0.5, 0.00013, 0.01, 0.03, 0.01, 0.03)),
//            Map.entry(Map.entry(Zvery.SCALOLASY, Style.KRAKODIL), new StatisticPreodPrepyat(2.8,  0.00009, 3.0, 0.00006, 0.5, 0.00013, 0.01, 0.03, 0.01, 0.03)),
//            Map.entry(Map.entry(Zvery.SCALOLASY, Style.KAZEROG),  new StatisticPreodPrepyat(2.2,  0.00010, 2.0, 0.00009, 0.5, 0.00013, 0.01, 0.03, 0.01, 0.03)),
//            Map.entry(Map.entry(Zvery.SCALOLASY, Style.SLON),     new StatisticPreodPrepyat(1.5,  0.00012, 1.2, 0.00012, 0.5, 0.00013, 0.01, 0.03, 0.01, 0.03)),
//
//            // Пловцы: крокодилы самые сильные в воде
//            Map.entry(Map.entry(Zvery.PLOVCY, Style.OBEZIAN),  new StatisticPreodPrepyat(8.0, 0.00006, 1.0, 0.00010, 1.8, 0.00008, 0.01, 0.03, 0.01, 0.03)),
//            Map.entry(Map.entry(Zvery.PLOVCY, Style.TIGR),    new StatisticPreodPrepyat(7.5, 0.00007, 1.0, 0.00010, 1.7, 0.00009, 0.01, 0.03, 0.01, 0.03)),
//            Map.entry(Map.entry(Zvery.PLOVCY, Style.KRAKODIL), new StatisticPreodPrepyat(9.0, 0.00005, 1.0, 0.00010, 2.2, 0.00007, 0.01, 0.03, 0.01, 0.03)),
//            Map.entry(Map.entry(Zvery.PLOVCY, Style.KAZEROG),  new StatisticPreodPrepyat(6.5, 0.00008, 1.0, 0.00010, 1.4, 0.00010, 0.01, 0.03, 0.01, 0.03)),
//            Map.entry(Map.entry(Zvery.PLOVCY, Style.SLON),     new StatisticPreodPrepyat(5.0, 0.00010, 1.0, 0.00010, 1.2, 0.00012, 0.01, 0.03, 0.01, 0.03)),
//
//            // Бойцы и силачи: тут можно сделать упор на силу/бой, а не на скорость бега
//            Map.entry(Map.entry(Zvery.BOICY, Style.OBEZIAN),   new StatisticPreodPrepyat(6.0, 0.00008, 1.0, 0.00010, 0.5, 0.00013, 1.5, 0.02, 0.8, 0.04)),
//            Map.entry(Map.entry(Zvery.BOICY, Style.TIGR),     new StatisticPreodPrepyat(7.0, 0.00007, 1.0, 0.00010, 0.5, 0.00013, 1.8, 0.02, 0.9, 0.04)),
//            Map.entry(Map.entry(Zvery.BOICY, Style.KRAKODIL), new StatisticPreodPrepyat(6.5, 0.00008, 1.0, 0.00010, 0.5, 0.00013, 1.6, 0.02, 0.85, 0.04)),
//            Map.entry(Map.entry(Zvery.BOICY, Style.KAZEROG),  new StatisticPreodPrepyat(5.5, 0.00009, 1.0, 0.00010, 0.5, 0.00013, 1.3, 0.02, 0.7, 0.04)),
//            Map.entry(Map.entry(Zvery.BOICY, Style.SLON),     new StatisticPreodPrepyat(4.5, 0.00010, 1.0, 0.00010, 0.5, 0.00013, 1.1, 0.02, 0.6, 0.04)),
//
//            Map.entry(Map.entry(Zvery.SILACHY, Style.OBEZIAN),new StatisticPreodPrepyat(5.0, 0.00009, 1.0, 0.00010, 0.5, 0.00013, 0.01, 0.03, 1.4, 0.02)),
//            Map.entry(Map.entry(Zvery.SILACHY, Style.TIGR),   new StatisticPreodPrepyat(5.5, 0.00008, 1.0, 0.00010, 0.5, 0.00013, 0.01, 0.03, 1.5, 0.02)),
//            Map.entry(Map.entry(Zvery.SILACHY, Style.KRAKODIL),new StatisticPreodPrepyat(5.2, 0.00009, 1.0, 0.00010, 0.5, 0.00013, 0.01, 0.03, 1.45, 0.02)),
//            Map.entry(Map.entry(Zvery.SILACHY, Style.KAZEROG), new StatisticPreodPrepyat(4.8, 0.00010, 1.0, 0.00010, 0.5, 0.00013, 0.01, 0.03, 1.35, 0.02)),
//            Map.entry(Map.entry(Zvery.SILACHY, Style.SLON),    new StatisticPreodPrepyat(4.0, 0.00011, 1.0, 0.00010, 0.5, 0.00013, 0.01, 0.03, 1.2, 0.02))
//    );
//
//    public static  StatisticPreodPrepyat get(Zvery zvery,Style style){
//        return STATS.get(Map.entry(zvery,style));
//    }
//}
//
//public class Gonky{
//    private final Scanner scanner=new Scanner(System.in);
//    private volatile boolean begany =true;
//    private Path dataFile = Paths.get("race_results.txt");
//
//    private List<Komanda> komandas;
//    private Map<PrepyatstvieType,Double> distances=new EnumMap<>(PrepyatstvieType.class);
//    private List<Zvery> vipEtap=new ArrayList<>();
//    private Map<Gruppa,Double> totalVremyaKomandy=new HashMap<>();
//    private boolean isTraseStart=false;
//
//    public Gonky(){
//        komandas=sozdatyKomandy();
//        for (Gruppa g:Gruppa.values()){
//            totalVremyaKomandy.put(g,0.0);
//        }
//        ojidanDannie();
//    }
//
//    private void ojidanDannie() {
//        try {
//            if (dataFile.toFile().exists()) {
//                System.out.println("Результаты предыдущей гонки найдены файл(\"race_results.txt\")");
//            } else {
//                System.out.println("Файл резельтатов не найден-начнем новую гонку");
//            }
//        } catch (Exception e) {
//            System.out.println("Не удалось сохранить файл " + e.getMessage());
//        }
//    }
//    private void SohranityDannie(){
//        try {
//            java.nio.file.Files.writeString(dataFile,formaResultat());
//            System.out.println("Результат гонки сохранен в race_result.txt");
//        } catch (IOException e){
//            System.err.println("Ошибка сохранения результатов: "+ e.getMessage());
//        }
//    }
//
//    private String formaResultat(){
//        StringBuilder stringBuilder=new StringBuilder();
//        stringBuilder.append("==== ИТОГОВЫЕ РЕЗУЛЬТАТЫ ГОНКИ ===\n");
//        for(Map.Entry<Gruppa,Double> e:totalVremyaKomandy.entrySet()){
//            stringBuilder.append(e.getKey().getImya()).append(": ").append(String.format("%.2f", e.getValue())).append(" с\n");
//
//        }
//        Gruppa pobeditely=getPobeditely();
//        if(pobeditely!=null){
//            stringBuilder.append("Победитель: ").append(pobeditely.getImya()).append("\n");
//        }
//        return stringBuilder.toString();
//    }
//
//    private Gruppa getPobeditely(){
//        Gruppa pobeditely=null;
//        double minVremya=Double.MAX_VALUE;
//        for(Map.Entry<Gruppa,Double> e:totalVremyaKomandy.entrySet()) {
//            if(e.getValue()<minVremya){
//                minVremya=e.getValue();
//                pobeditely=e.getKey();
//            }
//        }
//        return pobeditely;
//    }
//    private List<Predmety> generaciyaPredmetov(int schet){
//        List<Predmety> predmeties =new ArrayList<>();
//        String[] bolishoyBonus={"Лодка","Снаряжение","Велосипед","Мечь","Подьемник"};
//        String[] maliyBonus={"Бревно","Веревка","Самокат","Палка","Рычаг"};
//        String[] neitralyBonus={"Попутный ветер","Склон","Хорошая дорога","Лазина","Помощник"};
//        String[] maliePotery ={"Вывех ноги","Разбитая рука","Вывех плеча","Травма головы","Надры живота"};
//        String[] bolishiePotery={"Порванные связки","Пролом черепа","Сломаная нога","Сломаная рука","Грыжа"};
//
//        for(int i=0;i<5 && predmeties.size()<schet;i++){
//            predmeties.add(new Predmety(bolishoyBonus[i],1.2+Math.random(),true));
//        }
//        for(int i=0;i<5 && predmeties.size()<schet;i++){
//            predmeties.add(new Predmety(maliyBonus[i],0.6+Math.random(),true));
//        }
//        for(int i=0;i<5 && predmeties.size()<schet;i++){
//            predmeties.add(new Predmety(neitralyBonus[i],0.2+Math.random(),true));
//        }
//        for(int i=0;i<5 && predmeties.size()<schet;i++){
//            predmeties.add(new Predmety(maliePotery[i],-(0.6+Math.random()),true));
//        }
//        for(int i=0;i<5 && predmeties.size()<schet;i++){
//            predmeties.add(new Predmety(bolishiePotery[i],-(1.2+Math.random()),true));
//        }
//        Collections.shuffle(predmeties);
//        return predmeties;
//    }
//
//    private int chitatyInt(){
//        while (true){
//            try {
//                return Integer.parseInt(scanner.nextLine().trim());
//            } catch (NumberFormatException e){
//                System.out.println("Введите коректное число");
//            }
//        }
//    }
//
//    private double chitatyDouble(){
//        while (true){
//            try {
//                return Double.parseDouble(scanner.nextLine().trim());
//            } catch (NumberFormatException e){
//                System.out.println("Введите коректное число (дистанция");
//            }
//        }
//    }
//
//    private String chitatyLiniyu(){
//        return scanner.nextLine();
//    }
//
//    private void pokMenu(){
//        System.out.println("\n=== Гонки зверей(Zvery) ====");
//        System.out.println("1.Задать дистанцию для прупятствий");
//        System.out.println("2.Задать порядок этапов(звери)");
//        System.out.println("3.Показать гонку (симуляция этапов).");
//        System.out.println("4.Показать текущие результаты.");
//        System.out.println("5.Сохранить результаты в файл.");
//        System.out.println("6.Запустить фоновый мониторинг трассы.");
//        System.out.println("0.Выход.");
//        System.out.print("> ");
//    }
//
//    private void ustDistance() {
//        Map<PrepyatstvieType, Double> maxLimits = Map.of(
//                PrepyatstvieType.BEG, 20000.0,
//                PrepyatstvieType.SCALOLASANIE, 5000.6,
//                PrepyatstvieType.PLAVANIE, 3000.6,
//                PrepyatstvieType.BOY, 1000.7,
//                PrepyatstvieType.TYAJESTY, 1000.6
//        );
//        final double MIN_DISTANCE = 0.1;
//
//        System.out.println("=== Установка дистанции для этапа в метрах ===");
//        System.out.println("Для каждого этапа есть свой максимальный лимит.");
//
//        for (PrepyatstvieType type : PrepyatstvieType.values()) {
//            String description = switch (type) {
//                case BEG -> "Бег по пересечёнке";
//                case SCALOLASANIE -> "Скалолазание";
//                case PLAVANIE -> "Плавание";
//                case BOY -> "Бой";
//                case TYAJESTY -> "Тяжести";
//            };
//
//            double max = maxLimits.get(type);
//
//            while (true) {
//                System.out.printf("%s (лимит: до %.1f м): ", description, max);
//                double distance = chitatyDouble();
//
//                if (distance < MIN_DISTANCE) {
//                    System.out.println("Ошибка: дистанция должна быть не меньше " + MIN_DISTANCE + " м. Попробуйте снова.");
//                    continue;
//                }
//
//                // ГЛАВНОЕ ИЗМЕНЕНИЕ ЗДЕСЬ:
//                if (distance > max) {
//                    System.out.printf("Ошибка: вы указали %.1f м, но максимальная дистанция для этапа «%s» — %.1f м. Попробуйте снова.%n",
//                            distance, description, max);
//                    continue;
//                }
//
//                distances.put(type, distance);
//                System.out.printf("[OK] Дистанция «%s» установлена: %.1f м.%n%n", description, distance);
//                break;
//            }
//        }
//    }
//
//
//
//    private void ustPoryadokEtap(){
//        vipEtap.clear();
//        System.out.println("Выберите порядок этапов по зверям: ");
//        System.out.println("1-Бегуны,2-Скалолазы,3-Пловцы,4-Боицы,5-Силачи");
//        for(int i=0;i<3;i++){
//            System.out.println("Этап "+(i+1)+"(1=Бегуны,2=Скалолазы,3=Пловцы,4=Бойцы,5=Силачи: ");
//            int choise=chitatyInt();
//            Zvery zvery=switch (choise){
//                case 1->Zvery.BEGUN;
//                case 2->Zvery.SCALOLASY;
//                case 3->Zvery.PLOVCY;
//                case 4->Zvery.BOICY;
//                case 5->Zvery.SILACHY;
//                default -> throw new IllegalArgumentException("Неверный выбор");
//            };
//            vipEtap.add(zvery);
//        }
//        System.out.println("Порядок этапов установлен.");
//
//    }
//    private void setBegany() {
//        if (distances.isEmpty() || vipEtap.isEmpty()) {
//            System.out.println("Сначала задайте дистанцию и порядок этапов.");
//            return;
//        }
//
//        isTraseStart = true;
//        totalVremyaKomandy.replaceAll((k, v) -> 0.0); // сброс времени команд
//
//        // Сбрасываем предметы у всех участников перед новым этапом
//        for (Komanda k : komandas) {
//            for (Soperniky s : k.getPamyaty()) {
//                s.setPredmety(null);
//            }
//        }
//
//        List<Predmety> ostavshPredmety = new ArrayList<>();
//
//        for (Zvery zvery : vipEtap) {
//            PrepyatstvieType prepyatstvieType = switch (zvery) {
//                case BEGUN -> PrepyatstvieType.BEG;
//                case SCALOLASY -> PrepyatstvieType.SCALOLASANIE;
//                case PLOVCY -> PrepyatstvieType.PLAVANIE;
//                case BOICY -> PrepyatstvieType.BOY;
//                case SILACHY -> PrepyatstvieType.TYAJESTY;
//            };
//
//            double distance = distances.get(prepyatstvieType);
//
//            System.out.println("\n--- Этап: " + zvery.getImya() + " (" + prepyatstvieType + "), дистанция " + distance + " м ---");
//
//            // Генерируем предметы один раз на этап
//            if (ostavshPredmety.isEmpty()) {
//                ostavshPredmety = generaciyaPredmetov(25);
//            }
//
//            System.out.println("Доступные бонусы/урон (25 шт.):");
//            for (int i = 0; i < ostavshPredmety.size(); i++) {
//                Predmety it = ostavshPredmety.get(i);
//                String type = it.isBonus() ? "Бонус" : "Урон";
//                System.out.printf("%d. %s (%s, изменение скорости: %.2f)%n",
//                        i, it.imya(), type, it.scorostyBonus());
//            }
//
//            // Собираем 3 уникальных номера
//            List<Integer> vibratyBonus = new ArrayList<>();
//            while (vibratyBonus.size() < 5) {
//                System.out.print("Введите номер предмета (0–24), ещё нужно выбрать " + (3 - vibratyBonus.size()) + ": ");
//                int idx = chitatyInt();
//
//                if (idx < 0 || idx >= ostavshPredmety.size()) {
//                    System.out.println("Недопустимый номер. Выберите от 0 до 24.");
//                    continue;
//                }
//                if (vibratyBonus.contains(idx)) {
//                    System.out.println("Этот номер уже выбран. Выберите другой.");
//                    continue;
//                }
//
//                vibratyBonus.add(idx);
//            }
//
//            // Находим всех участников этого типа (зверя)
//            List<Soperniky> prisutstUchastniki = new ArrayList<>();
//            for (Komanda k : komandas) {
//                for (Soperniky s : k.getPamyaty()) {
//                    if (s.getZvery() == zvery) {
//                        prisutstUchastniki.add(s);
//                    }
//                }
//            }
//
//            if (prisutstUchastniki.size() < 5) {
//                System.out.println("Внимание: участников типа '" + zvery.getImya() + "' меньше 5 ("
//                        + prisutstUchastniki.size() + "). Бонусы не будут распределены на этом этапе.");
//            } else {
//                // Назначаем бонусы первым 3 участникам
//                for (int i = 0; i < 5; i++) {
//                    Soperniky participant = prisutstUchastniki.get(i);
//                    Predmety bonusPredmet = ostavshPredmety.get(vibratyBonus.get(i));
//                    participant.setPredmety(bonusPredmet);
//
//                    String typeStr = bonusPredmet.isBonus() ? "Бонус" : "Штраф";
//                    System.out.println(participant.getImya() + " получил: " + bonusPredmet.imya()
//                            + " (" + typeStr + ", скорость: " + bonusPredmet.scorostyBonus() + ")");
//                }
//            }
//
//            System.out.println("\n--- Старт этапа участников ---");
//            for (Soperniky s : prisutstUchastniki) {
//                double vremya = s.sluchSobitie(distance, prepyatstvieType);
//                totalVremyaKomandy.merge(s.getKomanda(), vremya, Double::sum);
//
//                System.out.printf(
//                        "%s (%s, %s) - дистанция %.1f м, время: %.2f c, случайное событие: %.2f м/с, предмет: %s (%.2f)%n",
//                        s.getImya(),
//                        s.getKomanda().getImya(),
//                        s.getZvery().getImya(),
//                        distance,
//                        vremya,
//                        s.getSluchayniyBonus(),
//                        s.getPredmety() != null ? s.getPredmety().imya() : "нет",
//                        s.getPredmety() != null ? s.getPredmety().scorostyBonus() : 0.0
//                );
//            }
//
//            // Очищаем предметы у участников после этапа
//            for (Soperniky s : prisutstUchastniki) {
//                s.setPredmety(null);
//            }
//
//            // Удаляем использованные предметы из списка
//            List<Predmety> ispolizPredmety = new ArrayList<>();
//            for (int idx : vibratyBonus) {
//                ispolizPredmety.add(ostavshPredmety.get(idx));
//            }
//            ostavshPredmety.removeAll(ispolizPredmety);
//        }
//
//        // Вывод итогов гонки (только после всех этапов)
//        System.out.printf("\nТекущее суммарное время команд:%n");
//        for (Gruppa g : Gruppa.values()) {
//            System.out.printf("%s: %.2f c%n", g.getImya(), totalVremyaKomandy.getOrDefault(g, 0.0));
//        }
//
//        isTraseStart = false;
//        System.out.println("\n=== Гонка завершена ===");
//
//        Gruppa pobeditely = getPobeditely();
//        if (pobeditely != null) {
//            System.out.println("ПОБЕДИТЕЛЬ: " + pobeditely.getImya());
//        } else {
//            System.out.println("Не удалось определить победителя");
//        }
//    }
//
//    private void pokResult(){
//        if(totalVremyaKomandy.isEmpty()){
//            System.out.println("Нет результатов для показа.");
//            return;
//        }
//        System.out.println("\n=== Текущие результаты команд ===");
//        for(Gruppa g:Gruppa.values()){
//            double vremya=totalVremyaKomandy.getOrDefault(g,0.0);
//            System.out.printf("%s: %.2f c%n", g.getImya(),vremya);
//        }
//        Gruppa pobeditely=getPobeditely();
//        if(pobeditely!=null){
//            System.out.println("Лидер: "+pobeditely.getImya());
//        }
//    }
//
//    private void startMonitorNity(){
//        Thread monitor=new Thread(()->{
//            while (begany){
//                try{
//                    System.out.println("[Мониторинг] Трасс в норме, проверка каждые 5 секунд...");
//                    Thread.sleep(5000);
//                }catch (InterruptedException e){
//                    System.out.println("[Мониторинг] Поток оставлен.");
//                    break;
//                }
//            }
//        });
//        monitor.setDaemon(true);
//        monitor.start();
//        System.out.println("Фоновый мониторинг трассы запущен.");
//    }
//
//    private List<Komanda>sozdatyKomandy(){
//        List<Komanda> komanda=new ArrayList<>();
//
//        Komanda obesiany=new Komanda(Gruppa.OBEZIANY);
//        obesiany.addPamyaty(new Soperniky(Gruppa.OBEZIANY,Zvery.BEGUN,Style.OBEZIAN,"Павиан"));
//        obesiany.addPamyaty(new Soperniky(Gruppa.OBEZIANY,Zvery.SCALOLASY,Style.OBEZIAN,"Макака"));
//        obesiany.addPamyaty(new Soperniky(Gruppa.OBEZIANY,Zvery.PLOVCY,Style.OBEZIAN,"Бабуин"));
//        obesiany.addPamyaty(new Soperniky(Gruppa.OBEZIANY,Zvery.BOICY,Style.OBEZIAN,"Шимпанзе"));
//        obesiany.addPamyaty(new Soperniky(Gruppa.OBEZIANY,Zvery.SILACHY,Style.OBEZIAN,"Горилла"));
//
//        Komanda tigry=new Komanda(Gruppa.TIGRY);
//        tigry.addPamyaty(new Soperniky(Gruppa.TIGRY,Zvery.BEGUN,Style.TIGR,"Бенгал"));
//        tigry.addPamyaty(new Soperniky(Gruppa.TIGRY,Zvery.SCALOLASY,Style.TIGR,"Гора"));
//        tigry.addPamyaty(new Soperniky(Gruppa.TIGRY,Zvery.PLOVCY,Style.TIGR,"Река"));
//        tigry.addPamyaty(new Soperniky(Gruppa.TIGRY,Zvery.BOICY,Style.TIGR,"Воин"));
//        tigry.addPamyaty(new Soperniky(Gruppa.TIGRY,Zvery.SILACHY,Style.TIGR,"Амур"));
//
//
//        Komanda krokodily=new Komanda(Gruppa.KRAKODILY);
//        krokodily.addPamyaty(new Soperniky(Gruppa.KRAKODILY,Zvery.BEGUN,Style.KRAKODIL,"Индия"));
//        krokodily.addPamyaty(new Soperniky(Gruppa.KRAKODILY,Zvery.SCALOLASY,Style.KRAKODIL,"Нил"));
//        krokodily.addPamyaty(new Soperniky(Gruppa.KRAKODILY,Zvery.PLOVCY,Style.KRAKODIL,"Алегатор"));
//        krokodily.addPamyaty(new Soperniky(Gruppa.KRAKODILY,Zvery.BOICY,Style.KRAKODIL,"Австралия"));
//        krokodily.addPamyaty(new Soperniky(Gruppa.KRAKODILY,Zvery.SILACHY,Style.KRAKODIL,"Амазон"));
//
//
//        Komanda kozerogy=new Komanda(Gruppa.KOZEROGY);
//        kozerogy.addPamyaty(new Soperniky(Gruppa.KOZEROGY,Zvery.BEGUN,Style.KAZEROG,"Тибет"));
//        kozerogy.addPamyaty(new Soperniky(Gruppa.KOZEROGY,Zvery.SCALOLASY,Style.KAZEROG,"Поле"));
//        kozerogy.addPamyaty(new Soperniky(Gruppa.KOZEROGY,Zvery.PLOVCY,Style.KAZEROG,"Моряк"));
//        kozerogy.addPamyaty(new Soperniky(Gruppa.KOZEROGY,Zvery.BOICY,Style.KAZEROG,"Бородач"));
//        kozerogy.addPamyaty(new Soperniky(Gruppa.KOZEROGY,Zvery.SILACHY,Style.KAZEROG,"Буровик"));
//
//
//        Komanda slony=new Komanda(Gruppa.SLONY);
//        slony.addPamyaty(new Soperniky(Gruppa.SLONY,Zvery.BEGUN,Style.SLON,"Быстрый"));
//        slony.addPamyaty(new Soperniky(Gruppa.SLONY,Zvery.SCALOLASY,Style.SLON,"Циркач"));
//        slony.addPamyaty(new Soperniky(Gruppa.SLONY,Zvery.PLOVCY,Style.SLON,"Тихоня"));
//        slony.addPamyaty(new Soperniky(Gruppa.SLONY,Zvery.BOICY,Style.SLON,"Орк"));
//        slony.addPamyaty(new Soperniky(Gruppa.SLONY,Zvery.SILACHY,Style.SLON,"Тяжик"));
//
//        return komanda;
//
//    }
//
//    public void runLoop(){
//        while (begany){
//            pokMenu();
//            int choise=chitatyInt();
//            switch (choise){
//                case 1->ustDistance();
//                case 2->ustPoryadokEtap();
//                case 3->setBegany();
//                case 4->pokResult();
//                case 5->pokResult();
//                case 6->startMonitorNity();
//                case 0->{
//                    begany=false;
//                    System.out.println("Выход из гонки.");
//                }
//                default -> System.out.println("Неверная операция,попробуйте снова");
//            }
//        }
//    }
//
//    public static void main(String[] args){
//        Gonky gonky=new Gonky();
//        gonky.runLoop();
//    }
//}

