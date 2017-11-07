#!/usr/local/perl

my %names = (
#	'guoyuan' => 'xiao',
#	'shanjun' => 'chen',
#	'ming' => 'yao',
);

#my %names = qw(guoyuan, 'xiao', shanjun, 'chen', ming, 'yao');
	

print "Please input a given name: \n";
while(<STDIN>) {
	chomp();
	my $count = $names{$_};
	$count++;
	print "$count\n";
	$names{$_} = $count;
}

#my @myarray = %names;
#print "@myarray\n";

foreach (sort keys %names) {
	print "$_ has count of $names{$_}\n";
}




