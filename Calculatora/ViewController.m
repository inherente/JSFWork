//
//  ViewController.m
//  Calculatora
//
//  Created by Enrique Gutierrez on 9/11/13.
//  Copyright (c) 2013 inherente. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController
- (CalculatoraBrain *) brain {
    if (brain) {
        // do nothing
    } else {
        brain = [[CalculatoraBrain alloc] init];
    }
    return brain;
}
                 
                 
- (IBAction)digitPressed:(UIButton *)sender {
    NSString *digit = [[sender titleLabel] text];
    if (userIsInTheMiddleOfTypingNumber) {
        [display setText:[[display text] stringByAppendingString:digit]];
    } else {
     // [display setText:digit]; // Same thing below line of code
        display.text= digit;
        userIsInTheMiddleOfTypingNumber = YES;
    }
    
}

- (IBAction)operatorPressed:(UIButton *)sender {

    if (userIsInTheMiddleOfTypingNumber) {
        [[self brain] setOperand:[[display text] doubleValue] ];
        userIsInTheMiddleOfTypingNumber = NO;
    }
    NSString *operation = [[sender titleLabel] text];
    double result = [[self brain] performOperation:operation];
    [display setText:[NSString stringWithFormat:@"%g", result]];
    
    
    
}

@end
