//
//  ViewController.h
//  Calculatora
//
//  Created by Enrique Gutierrez on 9/11/13.
//  Copyright (c) 2013 inherente. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "CalculatoraBrain.h"

@interface ViewController : UIViewController {
    IBOutlet UILabel *display;
    CalculatoraBrain *brain;
    BOOL userIsInTheMiddleOfTypingNumber;
}
- (IBAction)digitPressed:(UIButton *)sender;
- (IBAction)operatorPressed:(UIButton *)sender;


@end
