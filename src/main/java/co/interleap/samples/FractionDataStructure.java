package co.interleap.samples;

public interface FractionDataStructure {
  int getNumerator();
  int getDenominator();
}

interface FractionObject {
  double getValue();
  String reducedFractionRepresentation();
}