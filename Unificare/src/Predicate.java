import java.util.List;

public class Predicate implements IPredicate, ITerm {
	
	private String name;
	private List<ITerm> arguments;
    private UnificationResultFactory factory;
    private ListFactory factoryList;
    private PredicateFactory factoryPredicate;

    private void initialize() {
        factoryList = new ListFactory();
        factory = new UnificationResultFactory();
        factoryPredicate = new PredicateFactory();
    }

    public Predicate() {
        initialize();
    }

    public Predicate(String name, List substitutedTerms) {
        initialize();
        this.name = name;
        this.arguments = substitutedTerms;
    }

    @Override
    public IUnificationResult unify(IPredicate otherPredicate){
		if(otherPredicate.hasDifferentName(name)){
            return factory.createNegativeResult();
        }
		
		return otherPredicate.unify(arguments);
	}

    @Override
    public IUnificationResult unify(IConstant iConstant) {
        return factory.createNegativeResult();
    }

    @Override
    public IUnificationResult unify(IVariable iVariable) {
        return ((ITerm)iVariable).unify((IPredicate)this);
    }

    @Override
	public IUnificationResult unify(List<ITerm> otherArguments) {
		if(otherArguments.size() != arguments.size()){
			return factory.createNegativeResult();
		}
		
		IUnificationResult finalResult = factory.createSuccessfulResult();
		
		for(int index = 0; index < arguments.size(); index++){
			ITerm firstTerm = arguments.get(index);
			ITerm secondTerm = otherArguments.get(index);
			firstTerm = finalResult.applySubstitutionsTo(firstTerm);
			secondTerm = finalResult.applySubstitutionsTo(secondTerm);
			
			IUnificationResult partialUnificationResult = firstTerm.unify(secondTerm);
			
			if(partialUnificationResult.wasNotSuccessful()){
				return factory.createNegativeResult();
			}
			
			finalResult.add(partialUnificationResult);
		}

		return finalResult;
	}

	@Override
	public boolean hasDifferentName(String otherName) {
		return name != otherName;
	}

    @Override
    public void print() {
        for (ITerm term: arguments) {
            term.print();
        }
    }

    @Override
	public IUnificationResult unify(ITerm secondTerm) {
		return secondTerm.unify((IPredicate)this);
	}

	@Override
	public ITerm apply(ISubstitution substitution) {
		List substitutedTerms = factoryList.create();
		for (ITerm term : arguments) {
			ITerm substitutedTerm = term.apply(substitution);
			substitutedTerms.add(substitutedTerm);
		}
		return factoryPredicate.create(name, substitutedTerms);
	}
}
