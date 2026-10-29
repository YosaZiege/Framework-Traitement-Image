# Design Patterns — Travail à Rendre

Réponses aux deux exercices : diagrammes de classes (Exercice 1) et
implémentation d'un Framework de traitement d'image (Exercice 2).

---

## Exercice 1 — Diagrammes de classes

Les diagrammes sont fournis au format PlantUML dans `docs/exercice1/`.
Pour les afficher, ouvrir les fichiers `.puml` dans un éditeur avec le plugin
PlantUML (IntelliJ, VS Code) ou sur https://www.plantuml.com.

| Situation | Pattern | Fichier |
|---|---|---|
| Figure = cercle / rectangle / groupe | **Composite** | `docs/exercice1/1-composite.puml` |
| Plugin squelette + parties variables + instanciation opaque | **Template Method** + **Factory Method** | `docs/exercice1/2-template-method-factory.puml` |
| Composant `traitement()` + responsabilités avant/après | **Decorator** | `docs/exercice1/3-decorator.puml` |
| Joueur.score notifie Couloir/Caméra/Gardien (couplage faible) | **Observer** | `docs/exercice1/4-observer.puml` |

---

## Exercice 2 — Framework de traitement d'image

L'image est un tableau d'entiers. Le Framework est **fermé à la modification**
et **ouvert à l'extension**.

### Patterns utilisés

- **Strategy** : `FilterStrategy` (`filter(int[])`), changeable dynamiquement.
- **Adapter** : `NonStandardAdapter` adapte l'ancienne implémentation
  `ImplNonStandard.appliquerFiltre(String, int[])` vers `filter(int[])`.
- **Template Method** : `Compressor.compresser(int[])` (méthode squelette
  `final`) délègue les détails à `compresserDetail(int[])` des sous-classes.

### Structure (`com.school.designpatterns.framework`)

- `FilterStrategy` : interface de filtrage.
- `filtres.FiltreInversion`, `FiltreSeuil` : implémentations standard.
- `filtres.ImplNonStandard` : ancienne implémentation (signature différente).
- `filtres.NonStandardAdapter` : adaptateur vers `FilterStrategy`.
- `Compressor` : classe abstraite (Template Method).
- `compression.CompressionRle`, `CompressionSimple` : sous-classes concrètes.
- `TraitementImage` : cœur du Framework (`filter`, `compresser`).
- `App` : application qui instancie dynamiquement les implémentations.

Diagramme : `docs/exercice2/framework.puml`.

### Exécution

```bash
mvn test          # lance les tests JUnit
mvn compile       # compile

# lancer l'application (saisir le nom complet des classes, ex. :
#   com.school.designpatterns.framework.filtres.FiltreInversion
#   com.school.designpatterns.framework.compression.CompressionRle)
mvn exec:java -Dexec.mainClass="com.school.designpatterns.framework.App"
```

L'application demande à l'utilisateur le nom de la classe de filtrage puis de
compression, les instancie dynamiquement (`Class.forName`) et applique les
traitements sur un tableau de test.
