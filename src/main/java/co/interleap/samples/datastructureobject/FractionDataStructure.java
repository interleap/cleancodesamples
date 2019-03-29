package co.interleap.samples.datastructureobject;

public interface FractionDataStructure {
  int getNumerator();
  int getDenominator();
}

interface FractionObject {
  double getValue();
  String reducedFractionRepresentation();
}