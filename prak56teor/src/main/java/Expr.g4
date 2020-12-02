grammar Expr;
r  : ID '=' (ID | Dig) (Act (ID | Dig))*;         // match keyword hello followed by an identifier
ID : [a-zA-Z_][a-zA-Z0-9_]*;             // match lower-case identifiers
Dig : [0-9]+;
Act : [+\-*/];
WS : [ \t\r\n]+ -> skip; // skip spaces, tabs, newlines