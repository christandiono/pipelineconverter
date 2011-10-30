#!/usr/bin/env perl

use strict;
use 5.10.0;
use Switch;

while (<STDIN>) {
    my $temp = $_;
    $temp =~ s/^([\s]*)private final ([^\s]*) //g;
    $temp =~ s/;$//g;
    chomp($temp);
    my $fieldname;
    my $attrname;
    $fieldname = $temp;

    switch ($fieldname) {
        case "myPackage" { $attrname = "package"; }
        case "fileType" { $attrname = "filetype"; }
        else { $attrname = $fieldname; }
    }

    say "xstream.bindAttributeToClassField($ARGV[0], \"$temp\", \"$temp\");";
}
