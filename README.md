# XSAMPLED: Generate random XMLs for a given XSD

## Summary
This is a WIP of a simple tool to generate random XMLs for a given XSD as laid out in the [XML Schema Part 1: Structures Second Edition](https://www.w3.org/TR/xmlschema-1/) and [XML Schema Part 2: Datatypes Second Edition](https://www.w3.org/TR/xmlschema-2/) specifications.

## Status
This is a work in progress. It is not yet ready for use.

Currently, the project consists of implementations of the following:
* Interfaces (for extensibility) with default implementations for generators of random values in the value spaces of primitive types (string, integer, etc.)
* An abstract class to map the generated values to corresponding lexical representations

The next steps will be:
* Simplifying primitive type generators by making them functional interfaces and grouping them by extending interfaces that are based on applicable facets
* Extending the aforementioned interfaces for primitive types to include generators for their built-in derived types (e.g. xs:integer -> xs:nonNegativeInteger)
* Implementing the generators for non-built-in simple types
* Implementing the generators for complex types
* Putting it all together in a command-line tool