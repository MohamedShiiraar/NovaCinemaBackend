package za.ac.cput.novacinemaapp.factory;

import za.ac.cput.novacinemaapp.domain.CardPayment;
import za.ac.cput.novacinemaapp.domain.LoyaltyProgram;
import za.ac.cput.novacinemaapp.service.ILoyaltyProgramService;
import za.ac.cput.novacinemaapp.util.Helper;

public class LoyaltyProgramFactory {
    public static LoyaltyProgram buildLoyaltyProgram(String id, String description, String rewards , String expirationPolicy, String signupBonus, String rules) {
        if (Helper.isNullOrEmpty(id) || Helper.isNullOrEmpty(description) || Helper.isNullOrEmpty(rewards) || Helper.isNullOrEmpty(expirationPolicy) ||Helper.isNullOrEmpty(signupBonus) || Helper.isNullOrEmpty(rules))
            return null;

        return new LoyaltyProgram.Builder()
                .setID(id)
                .setDescription(description)
                .setRewards(rewards)
                .setExpirationPolicy(expirationPolicy)
                .setSignupBonus(signupBonus)
                .setRules(rules)
                .build();
    }

    public static LoyaltyProgram buildLoyaltyProgram( String description, String rewards , String expirationPolicy, String signupBonus, String rules) {
        if ( Helper.isNullOrEmpty(description) || Helper.isNullOrEmpty(rewards) || Helper.isNullOrEmpty(expirationPolicy) ||Helper.isNullOrEmpty(signupBonus) || Helper.isNullOrEmpty(rules))
            return null;

        String id= Helper.generateId();
        return new LoyaltyProgram.Builder()
                .setID(id)
                .setDescription(description)
                .setRewards(rewards)
                .setExpirationPolicy(expirationPolicy)
                .setSignupBonus(signupBonus)
                .setRules(rules)
                .build();
    }
}