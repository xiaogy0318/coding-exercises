#!/usr/local/perl

my %names = (
	'guoyuan' => 'xiao',
	'shanjun' => 'chen',
	'ming' => 'yao',);

#my %names = qw(guoyuan, 'xiao', shanjun, 'chen', ming, 'yao');
	
my @myarray = %names;
print "@myarray\n";

print "Please input a given name: \n";
my $name = <STDIN>;
chomp($name);
#print($name);
print "Family name is: " . $names{$name} . "\n";


