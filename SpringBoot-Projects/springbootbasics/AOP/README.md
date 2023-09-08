# Aspect-Oriented Programming(AOP)

## Introduction
- Programming technique based on concept of an aspect
- Aspect encapsulates cross-cutting Concern
- concern means logic/functionality
- We cannot write logging or security class all the classes like controller , service or DAO
- Aspect can be reused at multiple location 
- Same Aspect/class applied based on configuration

## Benefits of AOP 
- Code for Aspect is defined in a single class
- Reduces code complexity
- Based on configuration,apply aspects selectively to different parts of app 
- No need to make changes to main application code 

## AOP Terminology
- Aspect     - module of code for a cross-cutting concern(logging,security,...)
- Advice     - what action is taken and when it should be applied 
- Join point - when to apply code during execution 
- Pointcut   - A predicate expression for where advice should be applied 

## Advice Types
- Before advice          - run before the method 
- After finally advice   - run after the method(finally)
- After returning advice - run after the method(successful execution)
- After throwing advice  - run after method(if exception thrown)
- Around advice          - run before and after method