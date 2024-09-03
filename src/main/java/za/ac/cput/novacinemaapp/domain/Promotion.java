package za.ac.cput.novacinemaapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Entity
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long promotionID;
    private String promotionName;
    private String promotionDescription;
    private float discountPercentage;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;

    public Promotion() {
    }

    public Promotion(Builder builder){
        this.promotionID = builder.promotionID;
        this.promotionName = builder.promotionName;
        this.promotionDescription = builder.promotionDescription;
        this.discountPercentage = builder.discountPercentage;
        this.validFrom = builder.validFrom;
        this.validUntil = builder.validUntil;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Promotion promotion = (Promotion) o;
        return Float.compare(discountPercentage, promotion.discountPercentage) == 0 && Objects.equals(promotionID, promotion.promotionID) && Objects.equals(promotionName, promotion.promotionName) && Objects.equals(promotionDescription, promotion.promotionDescription) && Objects.equals(validFrom, promotion.validFrom) && Objects.equals(validUntil, promotion.validUntil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(promotionID, promotionName, promotionDescription, discountPercentage, validFrom, validUntil);
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "promotionID=" + promotionID +
                ", promotionName='" + promotionName + '\'' +
                ", promotionDescription='" + promotionDescription + '\'' +
                ", discountPercentage=" + discountPercentage +
                ", validFrom=" + validFrom +
                ", validUntil=" + validUntil +
                '}';
    }

    public static class Builder{
        private Long promotionID;
        private String promotionName;
        private String promotionDescription;
        private float discountPercentage;
        private LocalDateTime validFrom;
        private LocalDateTime validUntil;

        public Builder setPromotionID(Long promotionID){
            this.promotionID = promotionID;
            return this;
        }
        public Builder setPromotionName(String promotionName){
            this.promotionName = promotionName;
            return this;
        }
        public Builder setPromotionDescription(String promotionDescription){
            this.promotionDescription = promotionDescription;
            return this;
        }
        public Builder setDiscountPercentage(float discountPercentage){
            this.discountPercentage = discountPercentage;
            return this;
        }
        public Builder setValidFrom(LocalDateTime validFrom){
            this.validFrom = validFrom;
            return this;
        }
        public Builder setValidUntil(LocalDateTime validUntil){
            this.validUntil = validUntil;
            return this;
        }

        public Builder copy(Promotion promotion){
            this.promotionID = promotion.promotionID;
            this.promotionName = promotion.promotionName;
            this.promotionDescription = promotion.promotionDescription;
            this.discountPercentage = promotion.discountPercentage;
            this.validFrom = promotion.validFrom;
            this.validUntil = promotion.validUntil;
            return this;
        }

        public Promotion build(){return new Promotion(this);}
    }
}
