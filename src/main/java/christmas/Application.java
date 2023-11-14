package christmas;

import christmas.controller.PromotionController;
import christmas.generator.BadgeGenerator;
import christmas.generator.BenefitsGenerator;
import christmas.generator.OrdersGenerator;
import christmas.generator.VisitDateGenerator;
import christmas.mapper.BadgeResponseMapper;
import christmas.mapper.BenefitResponseMapper;
import christmas.mapper.OrderResponseMapper;
import christmas.mapper.VisitDateResponseMapper;
import christmas.service.GeneratorService;
import christmas.service.MapperService;
import christmas.service.PromotionService;
import christmas.view.ConsoleInputView;
import christmas.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        final GeneratorService generatorService = new GeneratorService(new BadgeGenerator(),
                new BenefitsGenerator(),
                new OrdersGenerator(),
                new VisitDateGenerator());

        final MapperService mapperService = new MapperService(new BadgeResponseMapper(),
                new BenefitResponseMapper(),
                new OrderResponseMapper(),
                new VisitDateResponseMapper());

        final PromotionService promotionService = new PromotionService(generatorService, mapperService);
        final PromotionController promotionController = new PromotionController(new ConsoleInputView(), new ConsoleOutputView(), promotionService);
        promotionController.start();
    }
}
