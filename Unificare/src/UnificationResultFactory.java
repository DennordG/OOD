/**
 * @author Dennord
 * Created on 5/29/2018
 */
public class UnificationResultFactory {

    public IUnificationResult createSuccessfulResult() {
        return new UnificationResult();
    }

    public IUnificationResult createNegativeResult() {
        return new UnificationResult();
    }
}
