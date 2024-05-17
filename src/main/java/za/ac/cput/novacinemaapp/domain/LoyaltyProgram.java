package za.ac.cput.novacinemaapp.domain;
//GammaadMohamed_220208344
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;
@Entity
public class LoyaltyProgram {


    @Id
    private String id;

    private String description;

    private String rewards;
    private String expirationPolicy;

    private String signupBonus;
    private String rules;

    public LoyaltyProgram(Builder builder) {
        this.id = builder.id;
        this.description = builder.description;
        this.rewards = builder.rewards;
        this.expirationPolicy = builder.expirationPolicy;
        this.signupBonus = builder.signupBonus;
        this.rules = builder.rules;
    }

    public LoyaltyProgram() {


    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getRewards() {
        return rewards;
    }

    public String getExpirationPolicy() {
        return expirationPolicy;
    }

    public String getRules() {
        return rules;
    }

    public String getSignupBonus() {
        return signupBonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoyaltyProgram that = (LoyaltyProgram) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getRewards(), that.getRewards()) && Objects.equals(getExpirationPolicy(), that.getExpirationPolicy()) && Objects.equals(getSignupBonus(), that.getSignupBonus()) && Objects.equals(getRules(), that.getRules());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getRewards(), getExpirationPolicy(), getSignupBonus(), getRules());
    }

    @Override
    public String toString() {
        return "LoyaltyProgram{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", rewards='" + rewards + '\'' +
                ", expirationPolicy='" + expirationPolicy + '\'' +
                ", signupBonus='" + signupBonus + '\'' +
                ", rules='" + rules + '\'' +
                '}';
    }

    public static class Builder {
        private String id;

        private String description;

        private String rewards;
        private String expirationPolicy;

        private String signupBonus;
        private String rules;

        public Builder setID(String id) {
            this.id = id;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setRewards(String rewards) {
            this.rewards = rewards;
            return this;
        }

        public Builder setExpirationPolicy(String expirationPolicy) {
            this.expirationPolicy = expirationPolicy;
            return this;
        }

        public Builder setSignupBonus(String signupBonus) {
            this.signupBonus = signupBonus;
            return this;
        }

        public Builder setRules(String rules) {
            this.rules = rules;
            return this;
        }

        public Builder copy(LoyaltyProgram loyaltyProgram) {
            this.id = loyaltyProgram.id;
            this.description = loyaltyProgram.description;
            this.expirationPolicy = loyaltyProgram.expirationPolicy;
            this.signupBonus = loyaltyProgram.signupBonus;
            this.rules = loyaltyProgram.rules;
            return this;


        }

        public LoyaltyProgram build() {
            return new LoyaltyProgram(this);

        }
    }
}

