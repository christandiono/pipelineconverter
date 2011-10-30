#!/usr/bin/env perl

use 5.10.0;
use Switch;

while (<STDIN>) {
    $temp = $_;
    $temp =~ s/^([\s]*)private final ([^\s]*) //g;
    $temp =~ s/;$//g;
    chomp($temp);
    undef $fieldname;
    undef $attrname;
    $fieldname = $temp;

    switch ($fieldname) {
        case "myPackage" { $attrname = "package"; }
        case "fileType" { $attrname = "filetype"; }
        else { $attrname = $fieldname; }
    }

    say "xstream.bindAttributeToClassField($ARGV[0], \"$temp\", \"$temp\");";
}
