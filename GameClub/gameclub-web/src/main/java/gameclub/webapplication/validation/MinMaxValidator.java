package gameclub.webapplication.validation;


import model.GameModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinMaxValidator implements ConstraintValidator<MinMaxConstraint, GameModel> {


    @Override
    public void initialize(MinMaxConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(GameModel gameModel, ConstraintValidatorContext context) {

        return (gameModel.getNumOfPlayers_min() < gameModel.getNumOfPlayers_max()) && (gameModel.getPlayTime_min() < gameModel.getPlayTime_max());
    }
}
