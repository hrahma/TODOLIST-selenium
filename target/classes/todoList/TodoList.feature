@todolist
Feature: Exercice QA - TODOLIST
  Je souhaite effectuer une série de tests sur l'application TODOLIST

  Scenario: Exercice QA - TODOLIST
    Given Je me connecte sur l'application TODOLIST
    Then Les liens Tâches et Déconnexion apparaissent seulement quand l'utilisateur est identifié
    Then Lorsque les identifiants de connexion "Test" et "Test" sont incorrects, un message rouge apparait pour les alerter "Désolé, les identifiants sont incorrects."
    Then Les boutons connexion et ajout de tâches ne sont pas activés si tous les champs ne sont pas remplis "test@test.com" et "test"
    When J'ajoute une tache "Todo" "Adopter de bonne pratique de test" 
    Then Les données dans le localStorage sont mises à jour "Adopter de bonne pratique de test"
