//package autoservice.pattern;
//
//import autoservice.enum_a.ServiceType;
//import autoservice.interface_a.Service;
//
//public class ServiceFactory {
//    public static Service create(ServiceType type) {
//        // В более сложной версии можно возвращать разные реализации
//        return new SimpleService(type.getName(), type.getPrice());
//    }
//
//    // Простая реализация, чтобы не плодить лишние классы
//    public static class SimpleService implements Service {
//        private final String name;
//        private final double price;
//
//        public SimpleService(String name, double price) {
//            this.name = name;
//            this.price = price;
//        }
//
//        @Override
//        public String getName() {
//            return name;
//        }
//
//        @Override
//        public double getPrice() {
//            return price;
//        }
//    }
//}
