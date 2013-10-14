//
//  CalculatoraBrain.h
//  Calculatora
//
//  Created by Enrique Gutierrez on 9/11/13.
//  Copyright (c) 2013 inherente. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface CalculatoraBrain : NSObject {
    double operand;
    NSString *waitingOperation;
    double waitingOperand;
}
- (void) setOperand:(double) anOperand;
- (double)performOperation:(NSString *)operation;


@end
