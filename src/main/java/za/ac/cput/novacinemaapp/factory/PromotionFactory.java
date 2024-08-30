package za.ac.cput.novacinemaapp.factory;

import za.ac.cput.novacinemaapp.domain.Promotion;
import za.ac.cput.novacinemaapp.util.Helper;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class PromotionFactory {

    public static Promotion buildPromotion(String promotionName, String promotionDescription, float discountPercentage, LocalDateTime validFrom, LocalDateTime validUntil) {
        if (Helper.isNullOrEmpty(promotionName)
                || Helper.isNullOrEmpty(promotionDescription)
                || Helper.isNullOrEmpty(discountPercentage)
                || Helper.isNullOrEmpty(validFrom)
                || Helper.isNullOrEmpty(validUntil)) {
            return null;
        }

        return new Promotion.Builder()
                .setPromotionName(promotionName)
                .setPromotionDescription(promotionDescription)
                .setDiscountPercentage(discountPercentage)
                .setValidFrom(validFrom)
                .setValidUntil(validUntil).build();
    }
}
