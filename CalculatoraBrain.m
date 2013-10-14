//
//  CalculatoraBrain.m
//  Calculatora
//
//  Created by Enrique Gutierrez on 9/11/13.
//  Copyright (c) 2013 inherente. All rights reserved.
//

#import "CalculatoraBrain.h"

@implementation CalculatoraBrain
- (void) setOperand:(double) anOperand {
    operand = anOperand;
}
// You need to define private operation before you use them
// otherwise  you get a warning from the compiler.
- (void) performWaitingOperation{
    if( [ @"+" isEqual:waitingOperation]) {
        operand= waitingOperand + operand;
    } else if ([@"-" isEqual:waitingOperation]) {
        operand= waitingOperand - operand;
    } else if ([@"*" isEqual:waitingOperation]) {
        operand= waitingOperand * operand;
    } else if ([@"/" isEqual:waitingOperation]) {
        if (operand) {
            operand= waitingOperand / operand;
        }
    }
}
- (double)performOperation:(NSString *)operation {
    if ( [operation isEqual:@"sqrt"]) {
        operand= sqrt(operand);
    } else {
        [self performWaitingOperation];
        waitingOperation = operation;
        waitingOperand= operand;
    }
    return operand;
    
    
}

@end
